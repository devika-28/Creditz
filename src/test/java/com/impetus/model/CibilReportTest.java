package com.impetus.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class CibilReportTest {

	private CibilReport createTestSubject() {
		return new CibilReport();
	}

	@Test
	public void testGetPanCard() throws Exception {
		CibilReport testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPanCard();
	}

	@Test
	public void testSetPanCard() throws Exception {
		CibilReport testSubject;
		String panCard = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPanCard(panCard);
	}

	@Test
	public void testGetCreditScore() throws Exception {
		CibilReport testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCreditScore();
	}

	@Test
	public void testSetCreditScore() throws Exception {
		CibilReport testSubject;
		int creditScore = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCreditScore(creditScore);
	}

	@Test
	public void testGetAssetCost() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAssetCost();
	}

	@Test
	public void testSetAssetCost() throws Exception {
		CibilReport testSubject;
		float assetCost = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setAssetCost(assetCost);
	}

	@Test
	public void testGetLiabilities() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLiabilities();
	}

	@Test
	public void testSetLiabilities() throws Exception {
		CibilReport testSubject;
		float liabilities = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setLiabilities(liabilities);
	}

	@Test
	public void testIsBankruptcies() throws Exception {
		CibilReport testSubject;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.isBankruptcies();
	}

	@Test
	public void testSetBankruptcies() throws Exception {
		CibilReport testSubject;
		boolean bankruptcies = false;

		// default test
		testSubject = createTestSubject();
		testSubject.setBankruptcies(bankruptcies);
	}

	@Test
	public void testGetContactNumber() throws Exception {
		CibilReport testSubject;
		Long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContactNumber();
	}

	@Test
	public void testSetContactNumber() throws Exception {
		CibilReport testSubject;
		Long contactNumber = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setContactNumber(contactNumber);
	}

	@Test
	public void testGetMonthlyIncome() throws Exception {
		CibilReport testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMonthlyIncome();
	}

	@Test
	public void testSetMonthlyIncome() throws Exception {
		CibilReport testSubject;
		int monthlyIncome = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setMonthlyIncome(monthlyIncome);
	}

	@Test
	public void testGetCurrentBalance() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCurrentBalance();
	}

	@Test
	public void testSetCurrentBalance() throws Exception {
		CibilReport testSubject;
		float currentBalance = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCurrentBalance(currentBalance);
	}

	@Test
	public void testGetCategory() throws Exception {
		CibilReport testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCategory();
	}

	@Test
	public void testSetCategory() throws Exception {
		CibilReport testSubject;
		String category = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setCategory(category);
	}

	@Test
	public void testGetRepaymentTenure() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRepaymentTenure();
	}

	@Test
	public void testSetRepaymentTenure() throws Exception {
		CibilReport testSubject;
		float repaymentTenure = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setRepaymentTenure(repaymentTenure);
	}

	@Test
	public void testGetCreditLimit() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCreditLimit();
	}

	@Test
	public void testSetCreditLimit() throws Exception {
		CibilReport testSubject;
		float creditLimit = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCreditLimit(creditLimit);
	}

	@Test
	public void testGetCreditUtilization() throws Exception {
		CibilReport testSubject;
		float result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCreditUtilization();
	}

	@Test
	public void testSetCreditUtilization() throws Exception {
		CibilReport testSubject;
		float creditUtilization = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCreditUtilization(creditUtilization);
	}
}