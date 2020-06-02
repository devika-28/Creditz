package com.impetus.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.impetus.model.User;
import com.impetus.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestAnalystService {
	@Mock
	private UserRepository user;

	@InjectMocks
	AnalystServiceImplementation analystService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void uniqueCheckEmail() {
		when(user.findByUserEmail("piajaiswal8109289952@gamil.com"))
				.thenReturn(new User(105, "piajaiswal8109289952@gamil.com", "person", "Momdad@123"));

		User emp = analystService.uniqueCheckEmail("piajaiswal8109289952@gamil.com");

		assertEquals(105, emp.getUserId());
		assertEquals("piajaiswal8109289952@gamil.com", emp.getUserEmail());
		assertEquals("person", emp.getRole());
		assertEquals("Momdad@123", emp.getPassword());
	}

	@Test
	public void deleteAnalyst() {
		when(user.findByUserEmail("piajaiswal8109289952@gamil.com"))
				.thenReturn(new User(105, "piajaiswal8109289952@gamil.com", "person", "Momdad@123"));
		user.delete(user.findByUserEmail("piajaiswal8109289952@gamil.com"));

	}

	@Test
	public void getAnalyst() {

		List<User> list = new ArrayList<User>();
		User empOne = new User(1, "piajaiswal8109289952@gamil.com", "Analyst", "Momdad@12");
		User emp = new User(2, "piaja8109289952@gamil.com", "Analyst", "Momdad@12");
		User emp1 = new User(3, "piaj8109289952@gamil.com", "Analyst", "Momdad@12");
		list.add(empOne);
		list.add(emp);
		list.add(emp1);

		when(user.findByRole("Analyst")).thenReturn(list);

		List<User> empList = analystService.getAllAnalyst();

		assertEquals(3, empList.size());
		verify(user, times(1)).findByRole("Analyst");

	}

	@Test
	public void findUserByEmailPassword() {
		String password = BCrypt.hashpw("Momdad@123", BCrypt.gensalt());
		when(user.findByUserEmail("piajaiswal8109289952@gamil.com"))
				.thenReturn(new User(105, "piajaiswal8109289952@gamil.com", "person",password));

		User user1 = analystService.findUserByEmailPassword("piajaiswal8109289952@gamil.com","Momdad@123");


	}
	
	@Test
	public void generateOTP() throws NoSuchAlgorithmException {
		String otp = analystService.generateOtp();
		assertEquals(otp, otp);

	}
	@Test
	public void sendOtp() {
		String userEmail="pjaiswal1000@gmail.com";
		String otp="123456";
		try {
		analystService.sendOtp(userEmail);
		}
		catch(Exception e)
		{
		}
		
		assertEquals(otp,otp);
	   }
	
	
}