package com.impetus.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class OrganizationApplicationControllerTests {

	@Test
	public void testOrgApplication() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 9999 + "/getOrganizationApplicants";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("businessAge"));
		assertEquals(true, result.getBody().contains("employeeCount"));
		assertEquals(true, result.getBody().contains("applicationId"));
		assertEquals(true, result.getBody().contains("revenue"));
		assertEquals(true, result.getBody().contains("licenseNumber"));



		// Verify request succeed
	

	}
	
}
