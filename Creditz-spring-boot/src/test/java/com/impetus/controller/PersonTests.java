package com.impetus.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PersonTests {

	@Test
	public void testFindPersonByUserId() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 9999 + "/findPersonByUserId";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("Person"));

	}

	
}
