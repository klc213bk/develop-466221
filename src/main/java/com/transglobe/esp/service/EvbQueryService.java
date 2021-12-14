package com.transglobe.esp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transglobe.esp.bean.CasePremium;
import com.transglobe.esp.repository.EvbQueryRepository;

@Service
public class EvbQueryService {
	static final Logger LOG = LoggerFactory.getLogger(EvbQueryService.class);
	
	
	@Autowired
	private EvbQueryRepository evbQueryRepository;
	
	
	public List<CasePremium> getCasePremiumList(String dataDate, String internalId) {
		return evbQueryRepository.getCasePremiumList(dataDate, internalId);
	}
}
