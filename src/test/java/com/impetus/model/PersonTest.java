package com.impetus.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

public class PersonTest {

	private Person createTestSubject() {
		return new Person();
	}

	@Test
	public void testGetPersonId() throws Exception {
		Person testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPersonId();
	}

	@Test
	public void testSetPersonId() throws Exception {
		Person testSubject;
		long personId = 1;

		// default test
		testSubject = createTestSubject();
		testSubject.setPersonId(personId);
	}

	@Test
	public void testGetPersonName() throws Exception {
		Person testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPersonName();
	}

	@MethodRef(name = "setPersonName", signature = "(QString;)V")
	@Test
	public void testSetPersonName() throws Exception {
		Person testSubject;
		String personName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPersonName(personName);
	}

	@MethodRef(name = "getContact", signature = "()QString;")
	@Test
	public void testGetContact() throws Exception {
		Person testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getContact();
	}

	@Test
	public void testSetContact() throws Exception {
		Person testSubject;
		String contact = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setContact(contact);
	}

	@Test
	public void testGetAddress() throws Exception {
		Person testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAddress();
	}

	@Test
	public void testSetAddress() throws Exception {
		Person testSubject;
		String address = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setAddress(address);
	}

	@Test
	public void testGetUser() throws Exception {
		Person testSubject;
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUser();
	}

	@Test
	public void testSetUser() throws Exception {
		Person testSubject;
		User user = null;

		testSubject = createTestSubject();
		testSubject.setUser(user);
	}
}