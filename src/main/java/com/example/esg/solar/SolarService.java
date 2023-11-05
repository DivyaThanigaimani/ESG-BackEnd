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
		if(requestObj.getCategory().toUpperCase().equals("QUATERLY")) {
			double summerVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity();
			double fallVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity();
			double winterVal=solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity();
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
		else if(requestObj.getCategory().toUpperCase().equals("YEARLY")) {
			double summerThreeVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity()*3)/1000;
			double summerFiveVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity()*5)/1000;
			double summerTenVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_summer()*solarObj.getPanel_capacity()*10)/1000;
			
			double fallThreeVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity()*3)/1000;
			double fallFiveVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity()*5)/1000;
			double fallTenVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_fall()*solarObj.getPanel_capacity()*10)/1000;
			
			double winterThreeVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity()*3)/1000;
			double winterFiveVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity()*5)/1000;
			double winterTenVal=(solarObj.getCarbon_intensity()*solarObj.getEnergy_production_winter()*solarObj.getPanel_capacity()*10)/1000;
			
			YearlyWise yearObj=new YearlyWise();
			QuaterWise threeObj=yearObj.getNextThreeYears();
			
			if (threeObj == null) {
				threeObj = new QuaterWise();
				yearObj.setNextThreeYears(threeObj);
			}

			threeObj.setFall(fallThreeVal);
			threeObj.setSummer(summerThreeVal);
			threeObj.setWinter(winterThreeVal);
			
			QuaterWise fiveObj=yearObj.getNextFiveYears();
			
			if (fiveObj == null) {
				fiveObj = new QuaterWise();
				yearObj.setNextFiveYears(fiveObj);
			}

			fiveObj.setFall(fallFiveVal);
			fiveObj.setSummer(summerFiveVal);
			fiveObj.setWinter(winterFiveVal);
			
			QuaterWise tenObj=yearObj.getNextTenYears();
			
			if (tenObj == null) {
				tenObj = new QuaterWise();
				yearObj.setNextTenYears(tenObj);
			}

			tenObj.setFall(fallTenVal);
			tenObj.setSummer(summerTenVal);
			tenObj.setWinter(winterTenVal);
			respObj.setCarbonReductionYear(yearObj);	
			
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
