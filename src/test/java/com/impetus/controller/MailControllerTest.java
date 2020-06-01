//package com.impetus.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.tools.configuration.base.MethodRef;
//
//public class MailControllerTest {
//
//	private MailController createTestSubject() {
//		return new MailController();
//	}
//
//	@Test
//	public void testSend() throws Exception {
//		MailController testSubject;
//		String userEmail = "devikabihani@gmail.com";
//		String password = "Keshav@04";
//
//		// default test
//		testSubject = createTestSubject();
//		testSubject.send(userEmail, password);
//	}
//
//	@Test
//	public void testSendOtp() throws Exception {
//		MailController testSubject;
//		String userEmail = "devikabihani@gmail.com";
//		String otp = "123456789";
//
//		// default test
//		testSubject = createTestSubject();
//		testSubject.sendOtp(userEmail, otp);
//	}
//}