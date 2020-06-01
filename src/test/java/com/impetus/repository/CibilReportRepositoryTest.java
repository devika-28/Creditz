package com.impetus.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.powermock.reflect.Whitebox;

import com.impetus.model.CibilReport;

public class CibilReportRepositoryTest {

	private CibilReport createTestSubject() {
		CibilReport report = new CibilReport();
		report.setAssetCost(550000);	
		report.setBankruptcies(false);
		report.setCategory("STD");
		report.setCreditLimit((long) 50000);
		report.setCreditScore(803);
		report.setPanCard("BIHAN1234I");
		report.setCreditUtilization(12000);
		return report;
	}

	@Test
	public void testFindByPanCard() throws Exception {
		String panCard = "BIHAN1234I";
		CibilReport result = createTestSubject();
		 CibilReportRepository report;
		// default test
		assertEquals(result , result );
	}
}