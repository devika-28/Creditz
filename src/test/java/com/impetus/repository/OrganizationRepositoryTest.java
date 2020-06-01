//package com.impetus.repository;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//import org.powermock.reflect.Whitebox;
//
//import com.impetus.model.Organization;
//
//public class OrganizationRepositoryTest {
//
//	private OrganizationRepository createTestSubject() {
//		return new OrganizationRepository();
//	}
//
//	@Test
//	public void testGetOrganizationIdByUserId() throws Exception {
//		OrganizationRepository testSubject;
//		Long userId = null;
//		Long result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "getOrganizationIdByUserId", new Object[] { Long.class });
//	}
//
//	@Test
//	public void testFindOrganizationByUserId() throws Exception {
//		OrganizationRepository testSubject;
//		Long userId = null;
//		Organization result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findOrganizationByUserId", new Object[] { Long.class });
//	}
//}