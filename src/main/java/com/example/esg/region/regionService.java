package com.example.esg.region;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.esg.emissiontype.MeasuresDTO;
import com.example.esg.emissiontype.MeasuresRepository;

@Service
public class regionService {
    private final regionRepository regRepository;
    private final MeasuresRepository measuresRepository;
   

    @Autowired
    public regionService(regionRepository regRepository,MeasuresRepository measuresRepository ) {
        this.regRepository = regRepository;
        this.measuresRepository=measuresRepository;
    }
   
    public List<EmissionResponse> saveExcelData(List<regionDTO> regionList) {
    	List<EmissionResponse> emisionResList=new ArrayList<>();
    	
    	try {
            regRepository.saveAll(regionList);
            double totalEmission=this.regRepository.getTotalEmissionForCanada();
            for(regionDTO res:regionList) {
            	EmissionResponse obj=new EmissionResponse();
            	obj.setEmission_amt(res.getEmission_amt());
            	obj.setMeasures(res.getMeasures());
            	obj.setRegion(res.getRegion());
            	Optional<MeasuresDTO> measuresDTO = this.measuresRepository.findByMeasures(res.getMeasures());
                if (measuresDTO.isPresent()) {
                    MeasuresDTO measObj = measuresDTO.get();
                    obj.setScope(measObj.getScope());
                }
            	
            	obj.setUnit(res.getUnit());
            	obj.setPercent(calculatePercent(totalEmission,res.getEmission_amt()));
            	emisionResList.add(obj);
            }
            return emisionResList;
            
    	}catch (Exception e) {
            // Handle any exceptions here
    		return null;
        }
    	
    } 
    
    public double calculatePercent(double totalEmission,double emissionAmt) {
    	return Math.round((emissionAmt/totalEmission)*100);
    	
    }
   
    public List<CarbonResponseDTO> calculateCarbonData(List<CarbonDTO> carbonList) {
    	List<CarbonResponseDTO> carbonResList=new ArrayList<>();
    	
    	try {
           
            for(CarbonDTO res:carbonList) {
            	CarbonResponseDTO obj=new CarbonResponseDTO();
            	if(res.getMeasures().toUpperCase().equals("ELECTRICITY")) {
            		double carbon =0.4 * res.getEnergy_spent();
            		obj.setCarbon_produced(carbon);
            		obj.setMeasures(res.getMeasures());
            		obj.setUnit("Kg");
            		obj.setEnergy_consumed(res.getEnergy_spent());
            	}
            	if(res.getMeasures().toUpperCase().equals("NATURAL GAS")) {
            		double carbon =55* res.getEnergy_spent();
            		obj.setCarbon_produced(carbon);
            		obj.setMeasures(res.getMeasures());
            		obj.setUnit("Kg");
            		obj.setEnergy_consumed(res.getEnergy_spent());
            	}
            	if(res.getMeasures().toUpperCase().equals("WASTE")) {
            		double carbon =200 * res.getEnergy_spent();
            		obj.setCarbon_produced(carbon);
            		obj.setMeasures(res.getMeasures());
            		obj.setUnit("Kg");
            		obj.setEnergy_consumed(res.getEnergy_spent());
            	}
            	if(res.getMeasures().toUpperCase().equals("TRANSPORT")) {
            		double carbon =120 * res.getEnergy_spent();
            		obj.setCarbon_produced(carbon);
            		obj.setMeasures(res.getMeasures());
            		obj.setUnit("Kg");
            		obj.setEnergy_consumed(res.getEnergy_spent());
            	}
            	carbonResList.add(obj);
            }
            return carbonResList;
            
    	}catch (Exception e) {
            // Handle any exceptions here
    		return null;
        }
    	
    }
    
}
