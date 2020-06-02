package com.impetus.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;
import com.impetus.service.UserServiceImplementation;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserControllerTest {
	@InjectMocks
	private UserController userController;

	@Mock
	private UserServiceImplementation userService;

	@Test
	public void savePerson() {

		when(userService.savePerson(any(Person.class))).thenReturn(true);
		Person person = new Person();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");
		person.setPersonId(101);
		person.setPersonName("Pia");
		person.setContact("8109289952");
		person.setAddress("Indore");
		person.setUser(user);
		Person responseEntityperson1 = userController.savePerson(person);

	}

	@Test
	public void saveOrganization() {

		when(userService.saveOrganization(any(Organization.class))).thenReturn(true);
		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		Organization responseEntityperson1 = userController.saveOrganization(organization);

	}

	@Test
	public void saveAnalyst() {

		when(userService.saveAnalyst(any(User.class))).thenReturn(true);

		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		User responseEntityperson1 = userController.saveAnalyst(user);

	}
	@Test
	public void sendOTP() throws NoSuchAlgorithmException {
	    String userEmail="pjaiswal1000@gmail.com";
	    userController.sendOTP(userEmail);

	}
}
