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
//import com.impetus.model.User;
//
//public class UserRepositoryTest {
//
//	private UserRepository createTestSubject() {
//		return new UserRepository();
//	}
//
//	@Test
//	public void testFindByRole() throws Exception {
//		UserRepository testSubject;
//		String role = "";
//		List<User> result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByRole", new Object[] { role });
//	}
//
//	@Test
//	public void testFindByUserEmail() throws Exception {
//		UserRepository testSubject;
//		String userEmail = "";
//		User result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findByUserEmail", new Object[] { userEmail });
//	}
//
//	@Test
//	public void testUpdatePassword() throws Exception {
//		UserRepository testSubject;
//		String userEmail = "";
//		String password = "";
//
//		// default test
//		testSubject = createTestSubject();
//		Whitebox.invokeMethod(testSubject, "updatePassword", new Object[] { userEmail, password });
//	}
//}