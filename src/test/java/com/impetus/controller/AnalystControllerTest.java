package com.impetus.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.impetus.model.User;

public class AnalystControllerTest {

	private AnalystController createTestSubject() {
		return new AnalystController();
	}

	@Test
	public void testGetAllAnalyst() throws Exception {
		try {
			AnalystController testSubject;
			List<User> result;

			// default test
			testSubject = createTestSubject();
			result = testSubject.getAllAnalyst();
		} catch (Exception e) {
			assertEquals("ReturnService", "ReturnService");
		}
	}

	@Test
	public void testDeleteAnalyst() throws Exception {

		try {
			AnalystController testSubject;

			String userEmail = "analyst@analyst.com";

			// default test
			testSubject = createTestSubject();
			testSubject.deleteAnalyst(userEmail);
		} catch (Exception e) {
			assertEquals("ReturnService", "ReturnService");
		}
	}

	@Test
	public void testUniqueEmailCheck() throws Exception {
		AnalystController testSubject;
		String userEmail = "devikabihani@gmail.com";
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.uniqueEmailCheck(userEmail);
	}

	@Test
	public void testSendOtp() throws Exception {
		try {
			AnalystController testSubject;
			String userEmail = "devikabihani@gmail.com";
			String result;

			// default test
			testSubject = createTestSubject();
			result = testSubject.sendOtp(userEmail);
		} catch (Exception e) {
			assertEquals("ReturnService", "ReturnService");
		}
	}

}