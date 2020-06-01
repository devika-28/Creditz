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
//import com.impetus.model.PersonApplicant;
//
//public class PersonApplicationControllerTest {
//
//	private PersonApplicationController createTestSubject() {
//		return new PersonApplicationController();
//	}
//
//	@Test
//	public void testPersonApplicantApplicationSubmit() throws Exception {
//		PersonApplicationController testSubject;
//		PersonApplicant application = null;
//		Map<String, Long> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.personApplicantApplicationSubmit(application);
//	}
//
//	@Test
//	public void testPersonHistory() throws Exception {
//		PersonApplicationController testSubject;
//		PersonApplicant userId = null;
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.personHistory(userId);
//	}
//
//	@Test
//	public void testGetAllPersonApplicant() throws Exception {
//		PersonApplicationController testSubject;
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.getAllPersonApplicant();
//	}
//
//	@Test
//	public void testFindTopPersonCreditors() throws Exception {
//		PersonApplicationController testSubject;
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = testSubject.findTopPersonCreditors();
//	}
//}