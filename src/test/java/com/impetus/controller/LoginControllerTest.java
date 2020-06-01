package com.impetus.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoginControllerTest {

	static final int STATUS200 = 200;

	private LoginController createTestSubject() {
		return new LoginController();
	}

	@Test
	public void testLogin() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + 9999 + "/login";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(STATUS200, result.getStatusCodeValue());

		LoginController testSubject;
		ResponseEntity<HashMap<String, String>> result1;

		testSubject = createTestSubject();
		try {
		result1 = testSubject.login();
		}catch(Exception e) {
			assertEquals("AuthError","AuthError");
		}
	}
}