package com.impetus.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class UserTest {

	private User createTestSubject() {
		return new User(1, "", "", "");
	}

	@Test
	public void testGetUserId() throws Exception {
		User testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUserId();
	}

	@Test
	public void testSetUserId() throws Exception {
		User testSubject;
		long userId = 1;

		// default test
		testSubject = createTestSubject();
		testSubject.setUserId(userId);
	}

	@Test
	public void testGetUserEmail() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUserEmail();
	}

	@Test
	public void testSetUserEmail() throws Exception {
		User testSubject;
		String userEmail = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setUserEmail(userEmail);
	}

	@Test
	public void testGetRole() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRole();
	}

	@Test
	public void testSetRole() throws Exception {
		User testSubject;
		String role = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setRole(role);
	}

	@Test
	public void testGetPassword() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPassword();
	}

	@MethodRef(name = "setPassword", signature = "(QString;)V")
	@Test
	public void testSetPassword() throws Exception {
		User testSubject;
		String password = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPassword(password);
	}

	@Test
	public void testThenReturn() throws Exception {
		User testSubject;
		User user = null;
		Object result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.thenReturn(user);
	}
}