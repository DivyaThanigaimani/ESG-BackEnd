package com.example.esg.solar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarService {
   private final SolarRepository solarRepository;
	 
 @Autowired
    public SolarService(SolarRepository solarRepository) {
        this.solarRepository = solarRepository;
 }
	   
	public SolarResponseModel getPercentage(SolarRequestModel requestObj) {
		
		SolarDTO solarObj=solarRepository.findByConditions(requestObj.getCountry(), requestObj.getRegion(), requestObj.getProvince());
		SolarResponseModel respObj=new SolarResponseModel();
		respObj.setCountry(solarObj.getCountry());
		respObj.setProvince(solarObj.getProvince());
		respObj.setRegion(solarObj.getRegion());
		if(requestObj.getCategory().toUpperCase().equals("QUATER")) {
			double summerVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity();
			double fallVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity();
			double winterVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity();
			QuaterWise obj=respObj.getCarbonReductionQuater();
			if (obj == null) {
			    obj = new QuaterWise();
			    respObj.setCarbonReductionQuater(obj);
			}

			obj.setFall(fallVal);
			obj.setSummer(summerVal);
			obj.setWinter(winterVal);
			//respObj.getCarbonReductionQuater().setFall(fallVal);
			
		}
		return respObj;
	}
	
    public double calculateCarbonProduction(String category,SolarDTO solarObj) {
    	if(category.toUpperCase().equals("SUMMER")) {
    		return solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity();
    	}else if(category.toUpperCase().equals("WINTER")) {
    		return solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity();
    	}else if(category.toUpperCase().equals("FALL")) {
    		return solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity();
    	}
    	return 0;
    }
}
