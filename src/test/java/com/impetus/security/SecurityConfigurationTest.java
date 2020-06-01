package com.impetus.security;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.powermock.reflect.Whitebox;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfigurationTest {

	private SecurityConfiguration createTestSubject() {
		return new SecurityConfiguration();
	}

	@Test
	public void testGetBasicAuthEntryPoint() throws Exception {
		SecurityConfiguration testSubject;
		CustomBasicAuthenticationEntryPoint result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getBasicAuthEntryPoint();
	}

	@Test
	public void testPasswordencoder() throws Exception {
		SecurityConfiguration testSubject;
		PasswordEncoder result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.passwordencoder();
	}
}