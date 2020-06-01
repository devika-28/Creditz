package com.impetus.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class SchedulerControllerTests {

	static final int STATUS200 = 200;

	private RestTemplate restTemplate;

	@BeforeEach
	public void setup() {
		restTemplate = new RestTemplate();
	}

//	@Test
//	public void testFindPersonByUserId() throws URISyntaxException {
//
//		final String baseUrl = "http://localhost:" + 9999 + "/sendUpdatePerson";
//		URI uri = new URI(baseUrl);
//
//		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
//		// Verify request succeed
//		assertEquals(STATUS200, result.getStatusCodeValue());
//
//	}

}
