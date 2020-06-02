package com.impetus.config;

import static org.junit.Assert.*;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class CORSFilterTest {

	private CORSFilter createTestSubject() {
		return new CORSFilter();
	}

	@Test
	public void testInit() throws Exception {
		CORSFilter testSubject;
		FilterConfig filterConfig = null;

		// default test
		testSubject = createTestSubject();
		testSubject.init(filterConfig);
	}

	@Test
	public void testDestroy() throws Exception {
		CORSFilter testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.destroy();
	}
}