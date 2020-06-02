package com.impetus.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.service.MailService;
import com.impetus.service.OrganizationApplicationService;
import com.impetus.service.PersonApplicationService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SchedularControllerTest {
	@Mock
	private PersonApplicationRepository personRepository;

	@Mock
	private OrganizationApplicationRepository repository;

	@Mock
	private PersonApplicationService service;

	@Mock
	private OrganizationApplicationService service1;

	@Mock
	private MailService notificationService;

	@InjectMocks
	private SchedularController schedularController;

	@Test
	public void statusUpdatePersonApplicants() {

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
		when(service.findApplicants()).thenReturn(list);
		schedularController.statusUpdatePersonApplicants();

	}

	@Test
	public void statusUpdateForOrganization() {

		List<OrganizationApplicant> list = new ArrayList<OrganizationApplicant>();
		OrganizationApplicant organizationApplicant = new OrganizationApplicant();

		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant.setBusinessAge(12);
		organizationApplicant.setApplicationId(12);
		organizationApplicant.setEmployeeCount(123);
		organizationApplicant.setEmailStatus("False");
		organizationApplicant.setLoanAmount(5000000);
		organizationApplicant.setLoanTenure(12);
		organizationApplicant.setUserId(user);
		organizationApplicant.setOrganizationId(organization);

		Organization organization1 = new Organization();
		OrganizationApplicant organizationApplicant1 = new OrganizationApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(102);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant1.setBusinessAge(12);
		organizationApplicant1.setApplicationId(12);
		organizationApplicant1.setEmployeeCount(123);
		organizationApplicant1.setEmailStatus("False");
		organizationApplicant1.setLoanAmount(5000000);
		organizationApplicant1.setLoanTenure(12);
		organizationApplicant1.setUserId(user1);
		organizationApplicant1.setOrganizationId(organization1);
		list.add(organizationApplicant);
		list.add(organizationApplicant1);

		when(service1.findApplicants()).thenReturn(list);

		schedularController.statusUpdateForOrganization();
	}

}
