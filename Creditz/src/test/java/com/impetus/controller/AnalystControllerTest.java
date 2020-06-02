package com.impetus.controller;

import java.util.List;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.impetus.model.User;

public class AnalystControllerTest {

	private AnalystController createTestSubject() {
		return new AnalystController();
	}

	@Test
	public void testUniqueEmailCheck() throws Exception {
		AnalystController testSubject;
		String userEmail = "anUnique@email.com";
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.uniqueEmailCheck(userEmail);
	}

	@Test
	public void testFindUser() throws Exception {
		AnalystController testSubject;
		String auth = "Basic YW5hbHlzdEBhbmFseXN0LmNvbTpEZXZpa2FAMjg=";
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findUser(auth);
	}
}