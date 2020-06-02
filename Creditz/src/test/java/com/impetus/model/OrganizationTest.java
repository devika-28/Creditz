package com.impetus.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class OrganizationTest {

	private Organization createTestSubject() {
		return new Organization();
	}

	@Test
	public void testGetOrganizationId() throws Exception {
		Organization testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getOrganizationId();
	}

	@Test
	public void testSetOrganizationId() throws Exception {
		Organization testSubject;
		long organizationId = 1;

		// default test
		testSubject = createTestSubject();
		testSubject.setOrganizationId(organizationId);
	}

	@Test
	public void testGetOrganizationName() throws Exception {
		Organization testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getOrganizationName();
	}

	@Test
	public void testSetOrganizationName() throws Exception {
		Organization testSubject;
		String organizationName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setOrganizationName(organizationName);
	}

	@Test
	public void testGetContact() throws Exception {
		Organization testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContact();
	}

	@Test
	public void testSetContact() throws Exception {
		Organization testSubject;
		long contact = 1;

		// default test
		testSubject = createTestSubject();
		testSubject.setContact(contact);
	}

	@Test
	public void testGetAddress() throws Exception {
		Organization testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAddress();
	}

	@Test
	public void testSetAddress() throws Exception {
		Organization testSubject;
		String address = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setAddress(address);
	}

	@Test
	public void testGetDirectorName() throws Exception {
		Organization testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDirectorName();
	}

	@Test
	public void testSetDirectorName() throws Exception {
		Organization testSubject;
		String directorName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setDirectorName(directorName);
	}

	@Test
	public void testGetUser() throws Exception {
		Organization testSubject;
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUser();
	}

	@Test
	public void testSetUser() throws Exception {
		Organization testSubject;
		User user = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setUser(user);
	}
}