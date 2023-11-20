package com.example.esg.region;

public class CarbonResponseDTO {

	private String measures;
    private String unit;
    private double carbon_produced;
    private double energy_consumed;
    
	public String getMeasures() {
		return measures;
	}
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getCarbon_produced() {
		return carbon_produced;
	}
	public void setCarbon_produced(double carbon_produced) {
		this.carbon_produced = carbon_produced;
	}
	public double getEnergy_consumed() {
		return energy_consumed;
	}
	public void setEnergy_consumed(double energy_consumed) {
		this.energy_consumed = energy_consumed;
	}
	
	
}
