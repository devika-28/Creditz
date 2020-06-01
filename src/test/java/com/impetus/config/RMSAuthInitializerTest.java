package com.impetus.config;

import static org.junit.Assert.*;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.powermock.reflect.Whitebox;

public class RMSAuthInitializerTest {

	private RMSAuthInitializer createTestSubject() {
		return new RMSAuthInitializer();
	}

	@Test
	public void testGetRootConfigClasses() throws Exception {
		RMSAuthInitializer testSubject;
		Class<?>[] result;

		// default test
		testSubject = createTestSubject();
		result = Whitebox.invokeMethod(testSubject, "getRootConfigClasses");
	}

	@Test
	public void testGetServletConfigClasses() throws Exception {
		RMSAuthInitializer testSubject;
		Class<?>[] result;

		// default test
		testSubject = createTestSubject();
		result = Whitebox.invokeMethod(testSubject, "getServletConfigClasses");
	}

	@Test
	public void testGetServletMappings() throws Exception {
		RMSAuthInitializer testSubject;
		String[] result;

		// default test
		testSubject = createTestSubject();
		result = Whitebox.invokeMethod(testSubject, "getServletMappings");
	}

	@Test
	public void testGetServletFilters() throws Exception {
		RMSAuthInitializer testSubject;
		Filter[] result;

		// default test
		testSubject = createTestSubject();
		result = Whitebox.invokeMethod(testSubject, "getServletFilters");
	}
}