package com.impetus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.User;
import com.impetus.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 *
 */
@RestController
public class RegistrationController {

	private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	/**
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("send-mail")
	public void send(@RequestParam String userEmail, @RequestParam String password) {

		/*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */

		user.setUserEmail(userEmail); // Receiver's email address
		user.setPassword(password);
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			LOG.error("exception ocuured", mailException);
		}

	}

	/**
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("send-mail/otp")
	public void sendOtp(@RequestParam String userEmail, @RequestParam String otp) {
		/*
		 * Here we will call sendOtpToUser() for Sending mail to the sender.
		 */
		try {
			notificationService.sendOtpToUser(userEmail, otp);
		} catch (MailException mailException) {
			LOG.error("exception ocuured", mailException);
		}

	}

}
