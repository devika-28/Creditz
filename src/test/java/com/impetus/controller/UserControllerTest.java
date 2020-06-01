//package com.impetus.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//
//import com.impetus.model.Organization;
//import com.impetus.model.Person;
//import com.impetus.model.User;
//
//public class UserControllerTest {
//
//	private UserController createTestSubject() {
//		return new UserController();
//	}
//
//	@Test
//	public void testSendOTP() throws Exception {
//		UserController testSubject;
//		String userEmail = "";
//		String result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.sendOTP(userEmail);
//	}
//
//	@Test
//	public void testSavePerson() throws Exception {
//		UserController testSubject;
//		Person user = null;
//		Person result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.savePerson(user);
//	}
//
//	@Test
//	public void testSaveOrganization() throws Exception {
//		UserController testSubject;
//		Organization user = null;
//		Organization result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.saveOrganization(user);
//	}
//
//	@Test
//	public void testSaveAnalyst() throws Exception {
//		UserController testSubject;
//		User user = null;
//		User result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.saveAnalyst(user);
//	}
//}