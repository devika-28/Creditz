package com.impetus.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.impetus.model.User;

public class TestMailService {

	@Mock
	private MailService mailService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void sendMail() {
		String email = "pjaiswal100@gmail.com";
		String subject = "subject";
		String text = "text";
		mailService.sendMail(email, subject, text);
	}

	@Test
	public void sendOtpToUser() {

		String userEmail = "pjaiswal1000@gmail.com";
		String otp = "123456";
		mailService.sendOtpToUser(userEmail, otp);
	}

	@Test
	public void sendEmailToApplicants() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "Approved";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants1() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "Rejected Low Credits";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants2() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "Rejected";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants3() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "Rejected Bad History";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants4() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "pending";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants5() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "Record Not Found";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmailToApplicants6() {
		String userEmail = "pjaiswal1000@gmail.com";
		String applicationStatus = "RejectedEarly";
		mailService.sendEmailToApplicants(userEmail, applicationStatus);
	}
	@Test
	public void sendEmail() {
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");
		mailService.sendEmail(user);
	}
}
