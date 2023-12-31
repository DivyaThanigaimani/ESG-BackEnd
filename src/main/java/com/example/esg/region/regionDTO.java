package com.example.esg.region;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emissiondetails")
public class regionDTO {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String region;
	    private String company;
	    private String measures;
	    private String unit;
	    private double emission_amt;
	    
	
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		
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
		public double getEmission_amt() {
			return emission_amt;
		}
		public void setEmission_amt(double emission_amt) {
			this.emission_amt = emission_amt;
		}
		
		
	    

}
