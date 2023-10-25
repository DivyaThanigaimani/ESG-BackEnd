package com.example.esg.region;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/upload")
public class regionController {
    private final regionService excelDataService;

    @Autowired
    public regionController(regionService excelDataService) {
        this.excelDataService = excelDataService;
    }

    @PostMapping("/excel")
    public ResponseEntity<List<EmissionResponse>> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            List<regionDTO> regionList = ExcelData.readExcel(file.getInputStream());
            List<EmissionResponse> emiList=excelDataService.saveExcelData(regionList);
            return new ResponseEntity <List<EmissionResponse>>(emiList,HttpStatus.OK);
        } catch (IOException e) {
        	 return null;
        }
    }
}

