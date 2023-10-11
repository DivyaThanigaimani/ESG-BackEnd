package com.example.esg.region;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {
    public static List<regionRequestModel> readExcel(InputStream inputStream) throws IOException {
        List<regionRequestModel> regionList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            regionRequestModel region = new regionRequestModel();
            int cellIdx = 0;
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();

                switch (cellIdx) {
                    case 0:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setRegion(currentCell.getStringCellValue());
                        break;
                    case 1:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setCompany(currentCell.getStringCellValue());
                        break;
                    case 2:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setScope1(currentCell.getStringCellValue());
                        break;
                    case 3:
                    	if (currentCell.getCellType() == CellType.STRING) 
                        region.setScope2(currentCell.getStringCellValue());
                        break;
                   
                    default:
                        break;
                }
                cellIdx++;
            }
            regionList.add(region);
        }
        workbook.close();
        return regionList;
    }
}

