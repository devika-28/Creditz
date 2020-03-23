package com.impetus.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.model.CibilReport;
import com.impetus.repository.CibilReportRepository;

public class CibilReportService {
    
    @Autowired
    CibilReportRepository cibilRepo;
    
    CibilReport getCibilReport(CibilReport cibilReport){
        return cibilRepo.findByPanCard(cibilReport.getPanCard());
//        System.out.println(currentUser.getAssetCost());
//        System.out.println(currentUser.getCategory());
//        System.out.println(currentUser.getCreditLimit());
    }
    
}
