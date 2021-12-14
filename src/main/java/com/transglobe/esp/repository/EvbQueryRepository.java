package com.transglobe.esp.repository;

import java.util.List;

import com.transglobe.esp.bean.CasePremium;

public interface EvbQueryRepository {
	
	public List<CasePremium> getCasePremiumList(String dataDate, String internalId) ;

}
