package com.impetus.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.model.CibilReport;
import com.impetus.repository.CibilReportRepository;

public class CibilReportService {

    @Autowired
    private CibilReportRepository cibilRepo;

    /** return CIBIL report.
     * @param cibilReport
     * @return CIBIL report */
    CibilReport getCibilReport(CibilReport cibilReport) {
        return cibilRepo.findByPanCard(cibilReport.getPanCard());
    }

}
