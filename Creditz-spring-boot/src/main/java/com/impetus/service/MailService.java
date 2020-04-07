package com.impetus.service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.impetus.model.User;

    @Service
	public class MailService {

		/*
		 * The Spring Framework provides an easy abstraction for sending email by using
		 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
		 * it as well as a starter module.
		 */
		private JavaMailSender javaMailSender;

		/**
		 * 
		 * @param javaMailSender
		 */
		@Autowired
		public MailService(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}

		public void sendEmail(User user) throws MailException {

			/*
			 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
			 * JavaMailSender extends the MailSender Interface which contains send()
			 * function. SimpleMailMessage Object is required because send() function uses
			 * object of SimpleMailMessage as a Parameter
			 */

			SimpleMailMessage mail = new SimpleMailMessage();
			
			mail.setTo(user.getUserEmail());
			mail.setSubject("Analyst Login Credentials");
			mail.setText("Your Login Credentials: "
					+ "  EmailAddress:"+user.getUserEmail()
					+"  your password :"+user.getPassword());

			/*
			 * This send() contains an Object of SimpleMailMessage as an Parameter
			 */
			javaMailSender.send(mail);
		}
		
		
		
		public void sendEmailToApplicants(String userEmail,String status,String applicationStatus ) throws MailException {

			/*
			 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
			 * JavaMailSender extends the MailSender Interface which contains send()
			 * function. SimpleMailMessage Object is required because send() function uses
			 * object of SimpleMailMessage as a Parameter
			 */
            System.out.println("inside mail Service");
			SimpleMailMessage mail = new SimpleMailMessage();
			
			mail.setTo(userEmail);
			mail.setSubject("Analyst Login Credentials");
			if(applicationStatus=="approved")
			{
			   mail.setText("We are happy to tell u your application has approved");
			}
			else
			{
		     mail.setText("We are sorry to tell u your application hasnot approved");
			}

			/*
			 * This send() contains an Object of SimpleMailMessage as an Parameter
			 */
			javaMailSender.send(mail);
		}


		/**
		 * This function is used to send mail that contains a attachment.
		 * 
		 * @param user
		 * @throws MailException
		 * @throws MessagingException
		 */
		public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(user.getUserEmail());
			helper.setSubject("Testing Mail API with Attachment");
			helper.setText("Please find the attached document below.");

			
			ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
			helper.addAttachment(classPathResource.getFilename(), classPathResource);

			javaMailSender.send(message);
		}

	}


