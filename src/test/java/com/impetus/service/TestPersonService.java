package com.impetus.service;

import com.impetus.repository.PersonRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.impetus.model.Person;
import com.impetus.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestPersonService {

	@Mock
	private PersonRepository personRepo;

	@InjectMocks
	private PersonServiceImplementation personService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findOrganizationByUserId() {
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		person.setPersonId(101);
		person.setPersonName("Pia");
		person.setContact("8109289952");
		person.setAddress("Indore");

		person.setUser(user);
		when(personRepo.findPersonByUserId(user.getUserId())).thenReturn(person);

		Person person1 = personService.findPersonByUserId(user.getUserId());

		assertEquals(101, person1.getPersonId());
		assertEquals("Indore", person1.getAddress());
		assertEquals("8109289952", person1.getContact());
		assertEquals("Pia", person1.getPersonName());

	}
}
