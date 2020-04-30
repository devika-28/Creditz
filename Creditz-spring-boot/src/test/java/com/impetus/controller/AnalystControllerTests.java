package com.impetus.controller;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AnalystControllerTests {

	@Test
	public void testGetAllAnalyst() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 9999 + "/getAllAnalyst";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("Analyst"));
	}

}
