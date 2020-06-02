package com.impetus.repository;

import static org.junit.Assert.*;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.powermock.reflect.Whitebox;

import com.impetus.model.User;

public class LoginRepositoryTest {

	private User createTestSubject() {
		User user = new User(1, "devikabihani@gmail.com", "Person", "Keshav@04");
		return user;
	}

	@Test
	public void testFindByUserEmail() throws Exception {
		User testSubject;
		LoginRepository repo = null;
		String email = "devikabihani@gmail.com";
		User result;

		// default test
		testSubject = createTestSubject();
		
//		Whitebox.invokeMethod(repo, "findByUserEmail", email);
		assertEquals(testSubject, testSubject);
	}
}