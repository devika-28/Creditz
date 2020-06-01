package com.impetus.security;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class HttpBasicAuthenticationHeaderTest {

	private HttpBasicAuthenticationHeader createTestSubject() {
		return new HttpBasicAuthenticationHeader();
	}

	@Test
	public void testDecoder() throws Exception {
		HttpBasicAuthenticationHeader testSubject;
		String auth = "Basic AbcgTzhjkzx";
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.decoder(auth);
	}
}