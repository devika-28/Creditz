//package com.impetus.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class OrganizationControllerTests {
//
//	static final int STATUS200 = 200;
//	private RestTemplate restTemplate;
//
//	@Before
//	public ResponseEntity<String> setup() throws URISyntaxException {
//		restTemplate = new RestTemplate();
//		final String baseUrl = "http://localhost:" + 9999 + "/findOrganizationByUserId";
//		URI uri = new URI(baseUrl);
//
//		 return restTemplate.getForEntity(uri, String.class);
//
//	}
//
//	@Test
//	public void testfindOrganizationByUserId() throws URISyntaxException {
//
//
//		ResponseEntity<String> result = setup();
//		// Verify request succeed
//		assertEquals(STATUS200, result.getStatusCodeValue());
//		assertEquals(true, result.getBody().contains("Organization"));
//		assertEquals(false, result.getBody().contains("Person"));
//
//	}
//
//}