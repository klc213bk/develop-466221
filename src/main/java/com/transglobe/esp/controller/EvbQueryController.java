package com.transglobe.esp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.transglobe.esp.bean.CasePremium;
import com.transglobe.esp.bean.EvbCasePremiumResponse;
import com.transglobe.esp.service.EvbQueryService;

@RestController
@RequestMapping("/service/esp/EvbQueryService")
public class EvbQueryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EvbQueryController.class);
	
	@Autowired
	private EvbQueryService evbQueryService;

	@RequestMapping(value = "getCases", method = { RequestMethod.GET})
	@ResponseBody
	public EvbCasePremiumResponse getCases(HttpServletRequest request, HttpServletRequest response) {
		
		String dataDate = request.getParameter("dataDate");
		String internalId = request.getParameter("internalId");

		LOGGER.info(">>>> dataDate1:" + dataDate);
		LOGGER.info(">>>> internalId1:" + internalId);

		String returnCode = "0000";
		String returnMsg = "";
		List<CasePremium> maleCasePremium = new ArrayList<>();
		List<CasePremium> femaleCasePremium = new ArrayList<>();

		try {
			List<CasePremium> casePremList = evbQueryService.getCasePremiumList(dataDate, internalId);

			for (CasePremium e : casePremList) {
				if ("M".equals(e.getGender())) {
					maleCasePremium.add(e);
				} else if ("F".equals(e.getGender())) {
					femaleCasePremium.add(e);
				} else {
					LOGGER.info(">>>> incorrect gender:{}, do nothing ", e.getGender());
				}
			}

		} catch (Throwable e) {
			LOGGER.error(">>>>> error={}", ExceptionUtils.getStackTrace(e));
			returnCode = "9900";
			returnMsg = e.getMessage();
		}

		EvbCasePremiumResponse evbResponse = new EvbCasePremiumResponse();

		evbResponse.setReturnCode(returnCode);
		evbResponse.setReturnMsg(returnMsg);
		evbResponse.setDataDate(dataDate);
		evbResponse.setInternalId(internalId);
		evbResponse.setMale(maleCasePremium);
		evbResponse.setFemale(femaleCasePremium);

		return evbResponse;
			
	}
}
