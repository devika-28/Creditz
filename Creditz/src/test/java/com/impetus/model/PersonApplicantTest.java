package com.impetus.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class PersonApplicantTest {

	private PersonApplicant createTestSubject() {
		return new PersonApplicant();
	}

	@Test
	public void testGetEmailStatus() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getEmailStatus();
	}

	@Test
	public void testSetEmailStatus() throws Exception {
		PersonApplicant testSubject;
		String emailStatus = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setEmailStatus(emailStatus);
	}

	@MethodRef(name = "getDate", signature = "()QString;")
	@Test
	public void testGetDate() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDate();
	}

	@MethodRef(name = "setDate", signature = "(QString;)V")
	@Test
	public void testSetDate() throws Exception {
		PersonApplicant testSubject;
		String date = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setDate(date);
	}

	@MethodRef(name = "getTime", signature = "()QString;")
	@Test
	public void testGetTime() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTime();
	}

	@MethodRef(name = "setTime", signature = "(QString;)V")
	@Test
	public void testSetTime() throws Exception {
		PersonApplicant testSubject;
		String time = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setTime(time);
	}

	@MethodRef(name = "getApplicationId", signature = "()J")
	@Test
	public void testGetApplicationId() throws Exception {
		PersonApplicant testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getApplicationId();
	}

	@Test
	public void testSetApplicationId() throws Exception {
		PersonApplicant testSubject;
		long applicationId = 1;

		// default test
		testSubject = createTestSubject();
		testSubject.setApplicationId(applicationId);
	}

	@Test
	public void testGetPancard() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPancard();
	}

	@Test
	public void testSetPancard() throws Exception {
		PersonApplicant testSubject;
		String pancard = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPancard(pancard);
	}

	@Test
	public void testGetLoanAmount() throws Exception {
		PersonApplicant testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLoanAmount();
	}

	@Test
	public void testSetLoanAmount() throws Exception {
		PersonApplicant testSubject;
		int loanAmount = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setLoanAmount(loanAmount);
	}

	@Test
	public void testGetAge() throws Exception {
		PersonApplicant testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAge();
	}

	@Test
	public void testSetAge() throws Exception {
		PersonApplicant testSubject;
		int age = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setAge(age);
	}

	@Test
	public void testGetGender() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getGender();
	}

	@Test
	public void testSetGender() throws Exception {
		PersonApplicant testSubject;
		String gender = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setGender(gender);
	}

	@Test
	public void testGetOccupation() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getOccupation();
	}

	@Test
	public void testSetOccupation() throws Exception {
		PersonApplicant testSubject;
		String occupation = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setOccupation(occupation);
	}

	@Test
	public void testGetApplicationStatus() throws Exception {
		PersonApplicant testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getApplicationStatus();
	}

	@Test
	public void testSetApplicationStatus() throws Exception {
		PersonApplicant testSubject;
		String applicationStatus = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setApplicationStatus(applicationStatus);
	}

	@Test
	public void testGetCriminalRecord() throws Exception {
		PersonApplicant testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCriminalRecord();
	}

	@Test
	public void testSetCriminalRecord() throws Exception {
		PersonApplicant testSubject;
		int criminalRecord = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCriminalRecord(criminalRecord);
	}

	@Test
	public void testGetBankruptcy() throws Exception {
		PersonApplicant testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getBankruptcy();
	}

	@Test
	public void testSetBankruptcy() throws Exception {
		PersonApplicant testSubject;
		int bankruptcy = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setBankruptcy(bankruptcy);
	}

	@Test
	public void testGetLoanTenure() throws Exception {
		PersonApplicant testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLoanTenure();
	}

	@Test
	public void testSetLoanTenure() throws Exception {
		PersonApplicant testSubject;
		int loanTenure = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setLoanTenure(loanTenure);
	}

	@Test
	public void testGetPersonId() throws Exception {
		PersonApplicant testSubject;
		Person result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPersonId();
	}

	@Test
	public void testSetPersonId() throws Exception {
		PersonApplicant testSubject;
		Person personId = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setPersonId(personId);
	}

	@Test
	public void testGetUserId() throws Exception {
		PersonApplicant testSubject;
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUserId();
	}

	@Test
	public void testSetUserId() throws Exception {
		PersonApplicant testSubject;
		User userId = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setUserId(userId);
	}
}