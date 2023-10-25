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
   
    
}
