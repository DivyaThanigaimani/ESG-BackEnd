package com.example.esg.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class regionService {
    private final regionRepository regRepository;

    @Autowired
    public regionService(regionRepository regRepository) {
        this.regRepository = regRepository;
    }

    public void saveExcelData(List<regionRequestModel> regionList) {
        for (regionRequestModel reg : regionList) {
            regionDTO excelData = new regionDTO();
            excelData.setCompany(reg.getCompany());
            excelData.setRegion(reg.getRegion());
            excelData.setScope1(reg.getScope1());
            excelData.setScope2(reg.getScope2());
           
            regRepository.save(excelData);
        }
    }
}
