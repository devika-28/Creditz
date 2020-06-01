//package com.impetus.controller;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//
//import com.impetus.model.OrganizationApplicant;
//
//public class OrganizationApplicationControllerTest {
//
//	private OrganizationApplicationController createTestSubject() {
//		return new OrganizationApplicationController();
//	}
//
//	@Test
//	public void testOrganizationApplicantApplicationSubmit() throws Exception {
//		OrganizationApplicationController testSubject;
//		OrganizationApplicant application = null;
//		Map<String, Long> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.organizationApplicantApplicationSubmit(application);
//	}
//
//	@Test
//	public void testOrganizationHistory() throws Exception {
//		OrganizationApplicationController testSubject;
//		OrganizationApplicant userId = null;
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.organizationHistory(userId);
//	}
//
//	@Test
//	public void testGetAllOrganizationApplicant() throws Exception {
//		OrganizationApplicationController testSubject;
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.getAllOrganizationApplicant();
//	}
//
//	@Test
//	public void testFindTopPersonCreditors() throws Exception {
//		OrganizationApplicationController testSubject;
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.findTopPersonCreditors();
//	}
//}