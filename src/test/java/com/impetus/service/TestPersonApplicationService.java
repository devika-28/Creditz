package com.impetus.service;

import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impetus.model.CibilReport;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestPersonApplicationService {

	@Mock
	private PersonApplicationRepository personApplication;

	@Mock
	private PersonRepository person;

	@InjectMocks
	private OrganizationApplicationServiceImplementation organizationApplication;

	@InjectMocks
	private PersonApplicationServiceImplementation personApplicationService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findApplicants()

	{
		List<PersonApplicant> list = new ArrayList<PersonApplicant>();
		PersonApplicant personApplicant = new PersonApplicant();
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person.setPersonId(101);
		person.setPersonName("pia");
		person.setContact("8109289952");
		person.setAddress("Indore");

		personApplicant.setAge(12);
		personApplicant.setApplicationId(12);
		personApplicant.setGender("Female");
		personApplicant.setEmailStatus("False");
		personApplicant.setLoanAmount(50000);
		personApplicant.setLoanTenure(12);
		personApplicant.setUserId(user);
		personApplicant.setPersonId(person);

		Person person1 = new Person();

		PersonApplicant personApplicant1 = new PersonApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person1.setPersonId(102);
		person1.setPersonName("pia");
		person1.setContact("8109289952");
		person1.setAddress("Indore");
		personApplicant1.setAge(12);
		personApplicant1.setApplicationId(12);
		personApplicant1.setGender("Female");
		personApplicant1.setEmailStatus("False");
		personApplicant1.setLoanAmount(50000);
		personApplicant1.setLoanTenure(12);
		personApplicant1.setUserId(user1);
		personApplicant1.setPersonId(person1);

		person.setUser(user);

		list.add(personApplicant1);
		list.add(personApplicant);

		when(personApplication.findByemailStatus("False")).thenReturn(list);

		List<PersonApplicant> empList = personApplicationService.findApplicants();

		assertEquals(2, empList.size());
		verify(personApplication, times(1)).findByemailStatus("False");
	}

	@Test
	public void getAllPersonApplicant() {
		List<PersonApplicant> list = new ArrayList<PersonApplicant>();
		PersonApplicant personApplicant = new PersonApplicant();
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person.setPersonId(101);
		person.setPersonName("pia");
		person.setContact("8109289952");
		person.setAddress("Indore");

		personApplicant.setAge(12);
		personApplicant.setApplicationId(12);
		personApplicant.setGender("Female");
		personApplicant.setEmailStatus("False");
		personApplicant.setLoanAmount(50000);
		personApplicant.setLoanTenure(12);
		personApplicant.setUserId(user);
		personApplicant.setPersonId(person);

		Person person1 = new Person();

		PersonApplicant personApplicant1 = new PersonApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person1.setPersonId(102);
		person1.setPersonName("pia");
		person1.setContact("8109289952");
		person1.setAddress("Indore");
		personApplicant1.setAge(12);
		personApplicant1.setApplicationId(12);
		personApplicant1.setGender("Female");
		personApplicant1.setEmailStatus("False");
		personApplicant1.setLoanAmount(50000);
		personApplicant1.setLoanTenure(12);
		personApplicant1.setUserId(user1);
		personApplicant1.setPersonId(person1);

		person.setUser(user);

		list.add(personApplicant1);
		list.add(personApplicant);

		when(personApplication.findAll()).thenReturn(list);

		List<PersonApplicant> empList = personApplicationService.getAllPersonApplicant();

		assertEquals(2, empList.size());
		verify(personApplication, times(1)).findAll();

	}

	@Test
	public void getAllTopCreditors() {
		List<PersonApplicant> list = new ArrayList<PersonApplicant>();
		PersonApplicant personApplicant = new PersonApplicant();
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person.setPersonId(101);
		person.setPersonName("pia");
		person.setContact("8109289952");
		person.setAddress("Indore");

		personApplicant.setAge(12);
		personApplicant.setApplicationId(12);
		personApplicant.setGender("Female");
		personApplicant.setEmailStatus("False");
		personApplicant.setLoanAmount(50000);
		personApplicant.setLoanTenure(12);
		personApplicant.setApplicationStatus("Approved");

		personApplicant.setUserId(user);
		personApplicant.setPersonId(person);

		Person person1 = new Person();

		PersonApplicant personApplicant1 = new PersonApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person1.setPersonId(102);
		person1.setPersonName("pia");
		person1.setContact("8109289952");
		person1.setAddress("Indore");
		personApplicant1.setAge(12);
		personApplicant1.setApplicationId(12);
		personApplicant1.setGender("Female");
		personApplicant1.setEmailStatus("False");
		personApplicant1.setLoanAmount(50000);
		personApplicant1.setLoanTenure(12);
		personApplicant1.setUserId(user1);
		personApplicant1.setPersonId(person1);
		personApplicant1.setApplicationStatus("Approved");

		person.setUser(user);

		list.add(personApplicant1);
		list.add(personApplicant);

		when(personApplication.findTopPersonCreditors("Approved")).thenReturn(list);

		List<PersonApplicant> empList = personApplicationService.findTopPersonCreditors();

		assertEquals(2, empList.size());
		verify(personApplication, times(1)).findTopPersonCreditors("Approved");

	}

	@Test
	public void getHistory() {
		List<PersonApplicant> list = new ArrayList<PersonApplicant>();
		PersonApplicant personApplicant = new PersonApplicant();
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person.setPersonId(101);
		person.setPersonName("pia");
		person.setContact("8109289952");
		person.setAddress("Indore");

		personApplicant.setAge(12);
		personApplicant.setApplicationId(12);
		personApplicant.setGender("Female");
		personApplicant.setEmailStatus("False");
		personApplicant.setLoanAmount(50000);
		personApplicant.setLoanTenure(12);
		personApplicant.setApplicationStatus("Approved");

		personApplicant.setUserId(user);
		personApplicant.setPersonId(person);

		Person person1 = new Person();

		PersonApplicant personApplicant1 = new PersonApplicant();

		person1.setPersonName("pia");
		person1.setContact("8109289952");
		person1.setAddress("Indore");
		personApplicant1.setAge(12);
		personApplicant1.setApplicationId(12);
		personApplicant1.setGender("Female");
		personApplicant1.setEmailStatus("False");
		personApplicant1.setLoanAmount(50000);
		personApplicant1.setLoanTenure(12);
		personApplicant1.setUserId(user);
		personApplicant1.setPersonId(person);
		personApplicant1.setApplicationStatus("Approved");

		person.setUser(user);

		list.add(personApplicant1);
		list.add(personApplicant);

		when(personApplication.findByUserId(106)).thenReturn(list);

		List<PersonApplicant> empList = personApplicationService.getHistory(personApplicant1);

		assertEquals(2, empList.size());

		verify(personApplication, times(1)).findByUserId((personApplicant1.getUserId()).getUserId());
	}

	private PersonApplicationServiceImplementation createTestSubject() {
		return new PersonApplicationServiceImplementation();
	}

//	@Test
//	public void testApproveOrDisapprove() throws Exception {
//		PersonApplicationServiceImplementation testSubject;
//		PersonApplicant application = null;
//		CibilReport reportOfCurrentUser = null;
//		String result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.approveOrDisapprove(application, reportOfCurrentUser);
//	}

//	@Test
//	public void testRiskMitigate() throws Exception {
//		PersonApplicationServiceImplementation testSubject;
//		PersonApplicant application = null;
//		Map<String, Long> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.riskMitigate(application);
//	}

	@Test
	public void testValidation() throws Exception {
		PersonApplicationServiceImplementation testSubject;
		int limit = 0;
		int loanAmount = 0;
		float creditUtilization = 0;
		float creditLimit = 0;
		int monthlyIncome = 0;
		float monthlyLiablities = 0;
		float currentBalance = 0;
		String result;

		// test 1
		testSubject = createTestSubject();
		loanAmount = 0;
		limit = 0;
		result = testSubject.validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome,
				monthlyLiablities, currentBalance);
		Assert.assertEquals("Rejected Bad History", result);

		// test 2
		testSubject = createTestSubject();
		loanAmount = 0;
		limit = -1;
		result = testSubject.validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome,
				monthlyLiablities, currentBalance);
		Assert.assertEquals("Rejected Low Credits", result);

		// test 3
		testSubject = createTestSubject();
		loanAmount = 0;
		limit = 1;
		result = testSubject.validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome,
				monthlyLiablities, currentBalance);
		Assert.assertEquals("Rejected Bad History", result);
	}

}
