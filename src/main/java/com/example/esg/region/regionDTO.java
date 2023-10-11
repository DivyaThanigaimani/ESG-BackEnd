package com.example.esg.region;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="region")
public class regionDTO {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String region;
	    private String company;
	    private String scope1;
	    private String scope2;
	
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
		public String getScope1() {
			return scope1;
		}
		public void setScope1(String scope1) {
			this.scope1 = scope1;
		}
		public String getScope2() {
			return scope2;
		}
		public void setScope2(String scope2) {
			this.scope2 = scope2;
		}
		
		
		
	    

}
