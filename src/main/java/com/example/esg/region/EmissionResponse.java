package com.example.esg.region;

public class EmissionResponse {

	    private String region;
	    private String measures;
	    private String unit;
	    private double emission_amt;
	    private double percent;
	    private int scope;
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
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
		public double getPercent() {
			return percent;
		}
		public void setPercent(double percent) {
			this.percent = percent;
		}
		public int getScope() {
			return scope;
		}
		public void setScope(int scope) {
			this.scope = scope;
		}
	    
	    
}
