package com.impetus.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

public class RegistrationRepositoryTest {

	private RegistrationRepository createTestSubject() {
		return new RegistrationRepository();
	}

//	@Test
//	public void testFindUserByUserMail() throws Exception {
//		RegistrationRepository testSubject;
//		String userMail = "";
//		User result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.findUserByUserMail(userMail);
//	}

//	@Test
//	public void testSavePerson() throws Exception {
//		RegistrationRepository testSubject;
//		Person user = null;
//		boolean result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.savePerson(user);
//	}

//	@Test
//	public void testSaveOrganization() throws Exception {
//		RegistrationRepository testSubject;
//		Organization user = null;
//		boolean result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.saveOrganization(user);
//	}

	@Test
	public void testSaveAnalyst() throws Exception {
		RegistrationRepository testSubject;
		User user = null;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.saveAnalyst(user);
	}
}