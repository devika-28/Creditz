package com.impetus.controller;

import static org.junit.Assert.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class OrganizationApplicationControllerTests {

	static final int STATUS200 = 200;
	private RestTemplate restTemplate;

	@Before
	public ResponseEntity<String> setup() throws URISyntaxException {
		restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + 9999 + "/getOrganizationApplicants";
		URI uri = new URI(baseUrl);

		 return restTemplate.getForEntity(uri, String.class);
	}

	@Test
	public void testOrgApplication() throws URISyntaxException {

		ResponseEntity<String> result = setup();
		assertEquals(STATUS200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("businessAge"));
		assertEquals(true, result.getBody().contains("employeeCount"));
		assertEquals(true, result.getBody().contains("applicationId"));
		assertEquals(true, result.getBody().contains("revenue"));
		assertEquals(true, result.getBody().contains("licenseNumber"));

		// Verify request succeed

	}

}
