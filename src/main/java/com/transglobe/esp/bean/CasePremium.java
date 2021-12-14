package com.transglobe.esp.bean;

import java.math.BigDecimal;

public class CasePremium {

	private String gender;
	
	private Long initialCaseCnt;
	
	private BigDecimal initialPremSum = BigDecimal.ZERO;
	
	private Long nextCaseCnt;
	
	private BigDecimal nextPremSum = BigDecimal.ZERO;
	
	private String chargeYear;
	
	private Integer firstYearNextCaseCnt;
	
	private BigDecimal firstYearNextPremSum;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getInitialCaseCnt() {
		return initialCaseCnt;
	}

	public void setInitialCaseCnt(Long initialCaseCnt) {
		this.initialCaseCnt = initialCaseCnt;
	}

	public BigDecimal getInitialPremSum() {
		return initialPremSum;
	}

	public void setInitialPremSum(BigDecimal initialPremSum) {
		this.initialPremSum = initialPremSum;
	}

	public Long getNextCaseCnt() {
		return nextCaseCnt;
	}

	public void setNextCaseCnt(Long nextCaseCnt) {
		this.nextCaseCnt = nextCaseCnt;
	}

	public BigDecimal getNextPremSum() {
		return nextPremSum;
	}

	public void setNextPremSum(BigDecimal nextPremSum) {
		this.nextPremSum = nextPremSum;
	}

	public String getChargeYear() {
		return chargeYear;
	}

	public void setChargeYear(String chargeYear) {
		this.chargeYear = chargeYear;
	}

	public Integer getFirstYearNextCaseCnt() {
		return firstYearNextCaseCnt;
	}

	public void setFirstYearNextCaseCnt(Integer firstYearNextCaseCnt) {
		this.firstYearNextCaseCnt = firstYearNextCaseCnt;
	}

	public BigDecimal getFirstYearNextPremSum() {
		return firstYearNextPremSum;
	}

	public void setFirstYearNextPremSum(BigDecimal firstYearNextPremSum) {
		this.firstYearNextPremSum = firstYearNextPremSum;
	}
	
	
	
	
}
