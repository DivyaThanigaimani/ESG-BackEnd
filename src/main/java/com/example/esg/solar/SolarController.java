package com.example.esg.solar;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/solar")
public class SolarController {
    private final SolarService solarService;
   

    @Autowired
    public SolarController(SolarService solarService) {
        this.solarService = solarService;
    }
	 @GetMapping("/getCarbonReducedPercentage")
	public ResponseEntity<SolarResponseModel> getPercentage(@RequestBody SolarRequestModel solarRequest) {
	    try {
	        SolarResponseModel solarResObj = solarService.getPercentage(solarRequest);
	        return new ResponseEntity <SolarResponseModel>(solarResObj,HttpStatus.OK);
	    } catch (Exception e) {
	    	 return null;
	    }
	}
	
}
