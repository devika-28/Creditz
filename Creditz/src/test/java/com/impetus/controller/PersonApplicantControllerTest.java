package com.impetus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;
import com.impetus.service.OrganizationApplicationServiceImplementation;
import com.impetus.service.PersonApplicationServiceImplementation;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PersonApplicantControllerTest {
	@InjectMocks
    PersonApplicationController personController;

	@Mock
	PersonApplicationServiceImplementation personApplicationService;

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

		when(personApplicationService.getAllPersonApplicant()).thenReturn(list);

		// when
		List<PersonApplicant> result = personController.getAllPersonApplicant();

		// then
		assertThat(result.size()).isEqualTo(2);

		assertThat(result.get(0).getPersonId()).isEqualTo(personApplicant1.getPersonId());

		assertThat(result.get(1).getPersonId()).isEqualTo(personApplicant.getPersonId());
	}

	@Test
	public void findApplicants() {
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

	when(personApplicationService.getAllPersonApplicant()).thenReturn(list);

	// when
	List<PersonApplicant> result = personController.getAllPersonApplicant();

	// then
	assertThat(result.size()).isEqualTo(2);

	assertThat(result.get(0).getPersonId()).isEqualTo(personApplicant1.getPersonId());

	assertThat(result.get(1).getPersonId()).isEqualTo(personApplicant.getPersonId());
	}

	
}
