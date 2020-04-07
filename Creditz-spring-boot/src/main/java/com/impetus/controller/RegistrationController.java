package com.impetus.controller;




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
	public void send(@RequestParam String userEmail,@RequestParam String password) {

		/*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
	
	
		user.setUserEmail(userEmail); //Receiver's email address
        user.setPassword(password);
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		    }   catch (MailException mailException) {
			System.out.println(mailException);
		}
		
	}
}

	