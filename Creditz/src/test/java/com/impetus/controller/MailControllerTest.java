package com.impetus.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.impetus.model.User;
import com.impetus.service.MailService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class MailControllerTest {

	@Mock
	private MailService notificationService;

	@InjectMocks
	private MailController mailController;


	@Test
	public void testSendOtp() throws Exception {

		String userEmail = "pjaiswal1000@gmail.com";
		String otp = "123456";
		
		mailController.sendOtp(userEmail, otp);
	}
}