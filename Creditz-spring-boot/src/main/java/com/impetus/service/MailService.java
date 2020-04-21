package com.impetus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	static final String OTPSUBJECT = "Email Otp Verification";
	static final String WELCOME = "Dear Applicant," + "\n\n" + "Thanku for applying for loan.";
	static final String DISAPPROVED = "We are Sorry to inform u that we are unable to approve your loan application.";
	static final String REJECTEDLOWCREDITS = " You have low Credit score as per our Requirement.";
	static final String REJECTED = "You might have some criminal records or you are bankcorrupt.";
	static final String APPROVED = "Volia ! Congratulations your application has been approved.";
	static final String PENDING = " WE will see you soon regarding your Application Status.";
	static final String RECORDNOTFOUND = "You dont have sufficient Credit History, please try again after some months wih some credit history.";
	static final String REJECTEDBADHISTORY = "As per your past loan history we are not seeing you as reliable person.";
	static final String ENDDATA = "Regards," + "\n\n" + "Creditz Group";
	static final String ADDITIONALDATA = "\r"
			+ "You can visit our nearest Branch with all documents proof as u have mentioned in your loan application for further processing. ";
	static final String OTPCONTENT = "As per your Request you want to change your password here is the otp to proceed further";

	/**
	 * This function is used to send mail.
	 * 
	 * @param user
	 * @throws MailException
	 */

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
		mail.setText("Your Login Credentials: " + "  EmailAddress:" + user.getUserEmail() + "  your password :"
				+ user.getPassword());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	public void sendEmailToApplicants(String userEmail, String status, String applicationStatus) throws MailException {

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
		switch (applicationStatus) {
		case "Approved":
			mail.setText(WELCOME + "\n" + APPROVED + "\n" + ADDITIONALDATA + "\n" + ENDDATA);
			break;
		case "Rejected Low Credits":
			mail.setText(WELCOME + "\n" + DISAPPROVED + "\n" + REJECTEDLOWCREDITS + "\n" + ENDDATA);
			break;
		case "Rejected":
			mail.setText(WELCOME + "\n" + DISAPPROVED + "\n" + REJECTED + "\n" + ENDDATA);
			break;
		case "Rejected Bad History":
			mail.setText(WELCOME + "\n" + DISAPPROVED + "\n" + REJECTEDBADHISTORY + "\n" + ENDDATA);
			break;
		case "Pending":
			mail.setText(WELCOME + "\n" + PENDING + "\n" + ENDDATA);
			break;
		case "Record Not Found":
			mail.setText(WELCOME + "\n" + DISAPPROVED + "\n" + RECORDNOTFOUND + "\n" + ENDDATA);

		}

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	/**
	 * Send otp to user on its email Address
	 *
	 * @param userEmail
	 * 
	 * @param userOtp
	 * 
	 */
	public void sendOtpToUser(String userEmail, String otp) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		System.out.println(userEmail.toString());
		mail.setTo(userEmail);
		mail.setSubject(OTPSUBJECT);
		mail.setText(OTPCONTENT + "\n" + otp);

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	
	
	
	
	
	public void	sendEmailToUser(String userEmail,String otp) throws  MailException {
		
		
		System.out.println("inside mail Service for otp");
		SimpleMailMessage mail = new SimpleMailMessage();
		System.out.println(otp);
		mail.setTo(userEmail);
		mail.setSubject("Email OTP Verification");
		   mail.setText("Hello,\n Thank you for register at our website\n please verify your otp ,Your otp numberis below \n"+otp);
		
		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		   System.out.println("sending mail");
		javaMailSender.send(mail);
		System.out.println("mail sent with otp");
			
			
			
		}
	
	

}
