package com.poc.springboot.model;

public class OOSProvider {
	
	private String providerId;
	private String providerIdType;
	private String effectiveDate;
	private String terminationDate;
	
	
	public OOSProvider() {
		super();
	}


	public OOSProvider(String providerId, String providerIdType, String effectiveDate, String terminationDate) {
		super();
		this.providerId = providerId;
		this.providerIdType = providerIdType;
		this.effectiveDate = effectiveDate;
		this.terminationDate = terminationDate;
	}
	
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderIdType() {
		return providerIdType;
	}
	public void setProviderIdType(String providerIdType) {
		this.providerIdType = providerIdType;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	

}
