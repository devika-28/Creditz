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


	@Test
	public void testSaveAnalyst() throws Exception {
		RegistrationRepository testSubject;
		User user = null;
		boolean result;

		testSubject = createTestSubject();
		result = testSubject.saveAnalyst(user);
	}
}