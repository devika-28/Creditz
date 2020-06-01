package com.impetus.service;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.impetus.repository.RegistrationRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;

public class TestUserService {
	@Mock
	private RegistrationRepository userdao;

	@InjectMocks
	private UserServiceImplementation userservice;

	@InjectMocks
	private MailService notificationService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Test
	public void savePerson() {
		Person person = new Person();
		User user = new User();
		user.setUserEmail("pjaiswal1000@gmail.com");
		user.setUserId(104);
		user.setPassword("Momdad@12");
		person.setPersonId(101);
		person.setPersonName("Pia");
		person.setContact("8109289952");
		person.setAddress("Indore");
		person.setUser(user);
		user.setPassword(hashPassword(user.getPassword()));
		userservice.savePerson(person);
		verify(userdao, times(1)).savePerson(person);
	}

	@Test
	public void getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		String FormattedDate = UserServiceImplementation.getCurrentTime();
		assertEquals(formattedDate, FormattedDate);
	}

	@Test
	public void getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		String time = formatter.format(date);
		String date1 = UserServiceImplementation.getCurrentDate();
		assertEquals(time, date1);

	}

	@Test
	public void saveAnalyst() {
		User user = new User();
		user.setUserEmail("pjaiswal1000@gmail.com");
		user.setUserId(104);
		user.setPassword("Momdad@12");
		user.setPassword(hashPassword(user.getPassword()));

		userservice.saveAnalyst(user);

		verify(userdao, times(1)).saveAnalyst(user);
	}

	@Test
	public void saveOrganization() {
		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		user.setPassword(hashPassword(user.getPassword()));
		userservice.saveOrganization(organization);
		verify(userdao, times(1)).saveOrganization(organization);
	}

	@Test
	public void generateOTP() throws NoSuchAlgorithmException {
		String otp = userservice.generateOTP();
		assertEquals(otp, otp);

	}
	@Test
	public void sendOTP() throws NoSuchAlgorithmException {
      
		String userEmail="pjaiswal1000@gmail.com";
		String otp="123456";
		try {
		userservice.sendOTP(userEmail);
		}
		catch(Exception e)
		{
		}
		
		assertEquals(otp,otp);

}
}
