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
//import com.impetus.model.OrganizationApplicant;
//
//public class OrganizationApplicationRepositoryTest {
//
//	private OrganizationApplicationRepository createTestSubject() {
//		return new OrganizationApplicationRepository();
//	}
//
//	@Test
//	public void testInsertApplication() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		int bankruptcy = 0;
//		int age = 0;
//		int criminalRecord = 0;
//		int employeeCount = 0;
//		String licenseNumber = "";
//		int loanAmount = 0;
//		int loanTenure = 0;
//		String organizationType = "";
//		String pancard = "";
//		long revenue = null;
//		String applicationStatus = "";
//		long organizationId = null;
//		long userId = null;
//		String emailStatus = "";
//		String date = "";
//		String time = "";
//
//		// default test
//		testSubject = createTestSubject();
//		Whitebox.invokeMethod(testSubject, "insertApplication",
//				new Object[] { bankruptcy, age, criminalRecord, employeeCount, licenseNumber, loanAmount, loanTenure,
//						organizationType, pancard, long.class, applicationStatus, long.class, long.class, emailStatus,
//						date, time });
//	}
//
//	@MethodRef(name = "getApplicationId", signature = "()QLong;")
//	@Test
//	public void testGetApplicationId() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		Long result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "getApplicationId");
//	}
//
//	@MethodRef(name = "findByemailStatus", signature = "(QString;)QList<QOrganizationApplicant;>;")
//	@Test
//	public void testFindByemailStatus() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		String emailStatus = "";
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByemailStatus", new Object[] { emailStatus });
//	}
//
//	@MethodRef(name = "updateEmailStatus", signature = "(JQString;)V")
//	@Test
//	public void testUpdateEmailStatus() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		long applicationId = null;
//		String status = "";
//
//		// default test
//		testSubject = createTestSubject();
//		Whitebox.invokeMethod(testSubject, "updateEmailStatus", new Object[] { long.class, status });
//	}
//
//	@MethodRef(name = "findTopPersonCreditors", signature = "(QString;)QList<QOrganizationApplicant;>;")
//	@Test
//	public void testFindTopPersonCreditors() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		String applicationStatus = "";
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findTopPersonCreditors", new Object[] { applicationStatus });
//	}
//
//	@MethodRef(name = "findByUserId", signature = "(J)QList<QOrganizationApplicant;>;")
//	@Test
//	public void testFindByUserId() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		long userId = null;
//		List<OrganizationApplicant> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByUserId", new Object[] { long.class });
//	}
//
//	@MethodRef(name = "getApplicationIdByUserId", signature = "(QLong;)QLong;")
//	@Test
//	public void testGetApplicationIdByUserId() throws Exception {
//		OrganizationApplicationRepository testSubject;
//		Long userId = null;
//		Long result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "getApplicationIdByUserId", new Object[] { Long.class });
//	}
//}