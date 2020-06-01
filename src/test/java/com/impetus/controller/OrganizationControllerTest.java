package com.impetus.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.impetus.model.Organization;

public class OrganizationControllerTest {

	private OrganizationController createTestSubject() {
		return new OrganizationController();
	}

	@Test
	public void testFindOrganizationByUserId() throws Exception {
		OrganizationController testSubject;
		Long userId = null;
		Organization result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.findOrganizationByUserId(userId);
	}
}