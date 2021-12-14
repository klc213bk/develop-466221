package com.transglobe.esp.bean;

import java.util.List;

public class EvbCasePremiumResponse extends EvbResponseMsg {

	private String dataDate;
	
	private String internalId;
	
	private List<CasePremium> male;
	
	private List<CasePremium> female;

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public List<CasePremium> getMale() {
		return male;
	}

	public void setMale(List<CasePremium> male) {
		this.male = male;
	}

	public List<CasePremium> getFemale() {
		return female;
	}

	public void setFemale(List<CasePremium> female) {
		this.female = female;
	}

	
	
}
