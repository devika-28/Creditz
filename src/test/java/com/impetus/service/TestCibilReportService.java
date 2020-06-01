package com.impetus.service;

import com.impetus.repository.CibilReportRepository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.impetus.model.CibilReport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestCibilReportService {

	@Mock
	private CibilReportRepository cibilRepo;

	@InjectMocks
	private CibilReportService cibilService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCibilReport() {
		CibilReport cibilReport = new CibilReport();
		cibilReport.setAssetCost(400000);
		cibilReport.setCategory("STD");
		cibilReport.setCreditLimit(80000000f);
		cibilReport.setCreditScore(800);
		cibilReport.setCreditUtilization(50f);
		cibilReport.setMonthlyIncome(800000);
		cibilReport.setPanCard("AAAAA1234B");
		cibilReport.setLiabilities(7000f);
		cibilReport.setCurrentBalance(700000f);
		when(cibilRepo.findByPanCard(cibilReport.getPanCard())).thenReturn(cibilReport);

		CibilReport cibilRepo = cibilService.getCibilReport(cibilReport);

		assertEquals(400000, cibilRepo.getAssetCost(), 1);
		assertEquals("STD", cibilRepo.getCategory());
		assertEquals(80000000, cibilRepo.getCreditLimit(), 1);
		assertEquals("AAAAA1234B", cibilRepo.getPanCard());
		assertEquals(7000, cibilRepo.getLiabilities(), 1);
		assertEquals(700000, cibilRepo.getCurrentBalance(), 1);
		assertEquals(80000000, cibilRepo.getCreditLimit(), 1);
		assertEquals(50, cibilRepo.getCreditUtilization(), 1);
		assertEquals(800000, cibilRepo.getMonthlyIncome());
		assertEquals(800, cibilRepo.getCreditScore());

	}

}
