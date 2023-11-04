package com.example.esg.solar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="solardetails")
public class SolarDTO {
	@Id
	private int id;
	private String country;
	private String province;
	private String region;
	private double panel_capacity;
	private double energy_production_summer;
	private double energy_production_winter;
	private double energy_production_fall;
	private double carbon_intensity;
	private String unit;
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
	public double getPanel_capacity() {
		return panel_capacity;
	}
	public void setPanel_capacity(double panel_capacity) {
		this.panel_capacity = panel_capacity;
	}
	public double getEnergy_production_summer() {
		return energy_production_summer;
	}
	public void setEnergy_production_summer(double energy_production_summer) {
		this.energy_production_summer = energy_production_summer;
	}
	public double getEnergy_production_winter() {
		return energy_production_winter;
	}
	public void setEnergy_production_winter(double energy_production_winter) {
		this.energy_production_winter = energy_production_winter;
	}
	public double getEnergy_production_fall() {
		return energy_production_fall;
	}
	public void setEnergy_production_fall(double energy_production_fall) {
		this.energy_production_fall = energy_production_fall;
	}
	public double getCarbon_intensity() {
		return carbon_intensity;
	}
	public void setCarbon_intensity(double carbon_intensity) {
		this.carbon_intensity = carbon_intensity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
	
	
}
