package com.impetus.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.impetus.model.Person;

public class PersonControllerTest {

	private PersonController createTestSubject() {
		return new PersonController();
	}

	@Test
	public void testFindPersonByUserId() throws Exception {
		PersonController testSubject;
		Long userId = null;
		Person result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findPersonByUserId(userId);
	}
}