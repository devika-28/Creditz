//package com.impetus.repository;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//import org.powermock.reflect.Whitebox;
//
//import com.impetus.model.Person;
//
//public class PersonRepositoryTest {
//
//	private PersonRepository createTestSubject() {
//		return new PersonRepository();
//	}
//
//	@Test
//	public void testGetPersonIdByUserId() throws Exception {
//		PersonRepository testSubject;
//		Long userId = null;
//		Long result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "getPersonIdByUserId", new Object[] { Long.class });
//	}
//
//	@Test
//	public void testFindPersonByUserId() throws Exception {
//		PersonRepository testSubject;
//		Long userId = null;
//		Person result;
//
//		// default test
//		testSubject = createTestSubject();
//		result = Whitebox.invokeMethod(testSubject, "findPersonByUserId", new Object[] { Long.class });
//	}
//}