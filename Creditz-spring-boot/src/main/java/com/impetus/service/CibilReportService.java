package com.impetus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.model.CibilReport;
import com.impetus.repository.CibilReportRepository;

public class CibilReportService {

	private static final Logger LOG = LoggerFactory.getLogger(CibilReportService .class);
	@Autowired
	private CibilReportRepository cibilRepo;

	/**
	 * return CIBIL report.
	 * 
	 * @param cibilReport
	 * @return CIBIL report
	 */
	CibilReport getCibilReport(CibilReport cibilReport) {
	    LOG.info("CibilReportService :: getCibilReport :: start finding of cibilReport in Cibil_database corresponding to pancard no:"+cibilReport.getPanCard());
		return cibilRepo.findByPanCard(cibilReport.getPanCard());
	}

}
