package com.example.esg.region;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {
    public static List<regionDTO> readExcel(InputStream inputStream) throws IOException {
        List<regionDTO> regionList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            regionDTO region = new regionDTO();
            int cellIdx = 0;
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();

                switch (cellIdx) {
                    case 0:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setMeasures(currentCell.getStringCellValue());
                        break;
                    case 1:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setUnit(currentCell.getStringCellValue());
                        break;
                    case 2:
                    	if (currentCell.getCellType() == CellType.NUMERIC) 
                        region.setEmission_amt(currentCell.getNumericCellValue());
                        break;
                   
                    default:
                        break;
                }
               
                cellIdx++;
            }
            region.setCompany("ERT");
            region.setRegion("Canada");
            regionList.add(region);
            
        }
        workbook.close();
        return regionList;
    }
}

