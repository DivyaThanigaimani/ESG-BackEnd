package com.example.esg.solar;

public class SolarResponseModel {

	private String country;
	private String province;
	private String region;
	
	private QuaterWise carbonReductionQuater;
	private YearlyWise carbonReductionYear;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public QuaterWise getCarbonReductionQuater() {
		return carbonReductionQuater;
	}
	public void setCarbonReductionQuater(QuaterWise carbonReductionQuater) {
		this.carbonReductionQuater = carbonReductionQuater;
	}
	public YearlyWise getCarbonReductionYear() {
		return carbonReductionYear;
	}
	public void setCarbonReductionYear(YearlyWise carbonReductionYear) {
		this.carbonReductionYear = carbonReductionYear;
	}
	
	
	
	
}
