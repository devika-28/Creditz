package com.impetus.security;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.springframework.security.core.AuthenticationException;

public class CustomBasicAuthenticationEntryPointTest {

	private CustomBasicAuthenticationEntryPoint createTestSubject() {
		return new CustomBasicAuthenticationEntryPoint();
	}


	@Test
	public void testAfterPropertiesSet() throws Exception {
		CustomBasicAuthenticationEntryPoint testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.afterPropertiesSet();
	}
}