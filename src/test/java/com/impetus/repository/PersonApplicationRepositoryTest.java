//package com.impetus.repository;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//import org.powermock.reflect.Whitebox;
//
//import com.impetus.model.PersonApplicant;
//
//public class PersonApplicationRepositoryTest {
//
//	private PersonApplicationRepository createTestSubject() {
//		return new PersonApplicationRepository();
//	}
//
//	@Test
//	public void testInsertApplication() throws Exception {
//		PersonApplicationRepository testSubject;
//		String pancard = "";
//		int loanAmount = 0;
//		int age = 0;
//		String gender = "";
//		String occupation = "";
//		String applicationStatus = "";
//		int criminalRecord = 0;
//		int bankruptcy = 0;
//		int loanTenure = 0;
//		long personId = null;
//		long userId = null;
//		String emailStatus = "";
//		String date = "";
//		String time = "";
//
//		// default test
//		testSubject = createTestSubject();
//		Whitebox.invokeMethod(testSubject, "insertApplication",
//				new Object[] { pancard, loanAmount, age, gender, occupation, applicationStatus, criminalRecord,
//						bankruptcy, loanTenure, long.class, long.class, emailStatus, date, time });
//	}
//
//	@Test
//	public void testGetApplicationId() throws Exception {
//		PersonApplicationRepository testSubject;
//		Long result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "getApplicationId");
//	}
//
//	@Test
//	public void testFindByUserId() throws Exception {
//		PersonApplicationRepository testSubject;
//		long userId = null;
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByUserId", new Object[] { long.class });
//	}
//
//	@Test
//	public void testUpdateEmailStatus() throws Exception {
//		PersonApplicationRepository testSubject;
//		long applicationId = null;
//		String status = "";
//
//		// default test
//		testSubject = createTestSubject();
//		Whitebox.invokeMethod(testSubject, "updateEmailStatus", new Object[] { long.class, status });
//	}
//
//	@Test
//	public void testFindByemailStatus() throws Exception {
//		PersonApplicationRepository testSubject;
//		String emailStatus = "";
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByemailStatus", new Object[] { emailStatus });
//	}
//
//	@Test
//	public void testFindTopPersonCreditors() throws Exception {
//		PersonApplicationRepository testSubject;
//		String applicationStatus = "";
//		List<PersonApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findTopPersonCreditors", new Object[] { applicationStatus });
//	}
//}