//package com.impetus.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestOperations;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PersonTests {
//
//	static final int STATUS200 = 200;
//	private RestTemplate restTemplate;
//
//	@Before
//	public RestTemplate setup() throws URISyntaxException {
//		restTemplate = new RestTemplate();
//
//		return restTemplate;
//	}
//
//	@Test
//	public void testFindPersonByUserId() throws URISyntaxException{
//
//		// Verify request succeed
//		final String baseUrl = "http://localhost:" + 9999 + "/findPersonByUserId";
//		URI uri = new URI(baseUrl);
//		ResponseEntity<String> result = ((RestOperations) setup()).getForEntity(uri, String.class);
//
////		assertEquals(STATUS200, result.getStatusCodeValue());
//		assertEquals(true, ((String) result.getBody()).contains("Person"));
//
//	}
//
//}
