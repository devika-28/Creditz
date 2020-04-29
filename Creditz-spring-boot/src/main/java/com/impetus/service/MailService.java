package com.impetus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public class MailService {

	private static final Logger LOG = LoggerFactory.getLogger(MailService.class);
	static final String APPLICATION_UPDATE_SUBJECT = "Loan application Status";
	static final String ANALYST_SUBJECT = "Financial Analyst login Credentials";
	static final String OTPSUBJECT = "Email OTP Verification";
	static final String WELCOME = "Dear Applicant," + "\n\n" + "Thank You for applying for loan, and believing in us!";
	static final String DISAPPROVED = "We are Sorry! But you loan application is Declined, Please refer to our website for possible reason as in why this may have occured.";
	static final String REJECTEDLOWCREDITS = "We are Sorry! But your application is Rejected. Reason: Your Credit score doesn't meet our eligiblity Criteria";
	static final String REJECTED = "We are Sorry! But you loan application is Declined, Please refer to our website for possible reason as in why this may have occured.";
	static final String APPROVED = "Volia ! Your application is Approved, please visit our nearest branch for further fomalities. Hope to see you soon!";
	static final String PENDING = " Your application is Pending, Please contact one of our officials, to see why this happened. We are sorry for the inconvinience.";
	static final String RECORDNOTFOUND = "We are Sorry! You do not have sufficient Credit History, please try again after some time wih some credit history.";
	static final String REJECTEDBADHISTORY = "We are Sorry! But you loan application is Declined, Please refer to our website for possible reason as in why this may have occured.";
	static final String ENDDATA = "Thanks and Regards," + "\n\n" + "Creditz Group";
	static final String ADDITIONALDATA = "\r"
			+ "You can visit our nearest Branch with all an original copy of your PAN card, Identity proof and bank statement for further processing. ";
	static final String OTPCONTENT = "Dear user, \nWe see you have requested for an OTP, Please note that it is valid only for one time use.\n\nNot You, please contact our officials.";

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	void sendMail(String email, String subject, String text) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject(subject);
		mail.setText(text);
		LOG.info("MailService:: sendMail::call sendMail method");
		javaMailSender.send(mail);
	}

	//
	/**
	 * This function is used to send mail.
	 * 
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(User user) {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		LOG.info("MailService:: sendEmail::call sendMail method");
		this.sendMail(user.getUserEmail(), ANALYST_SUBJECT, "Your Login Credentials: " + "  EmailAddress:"
				+ user.getUserEmail() + "  Your password :" + user.getPassword() + "\n" + ENDDATA);
	}

	public void sendEmailToApplicants(String userEmail, String estatus, String applicationStatus) {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userEmail);
		mail.setSubject(APPLICATION_UPDATE_SUBJECT);
		switch (applicationStatus) {
		case "Approved":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + APPROVED + "\n" + ADDITIONALDATA + "\n" + ENDDATA);
			break;
		case "Rejected Low Credits":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + DISAPPROVED + "\n" + REJECTEDLOWCREDITS + "\n" + ENDDATA);
			break;
		case "Rejected":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + DISAPPROVED + "\n" + REJECTED + "\n" + ENDDATA);
			break;
		case "Rejected Bad History":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + DISAPPROVED + "\n" + REJECTEDBADHISTORY + "\n" + ENDDATA);
			break;
		case "Pending":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT, WELCOME + "\n" + PENDING + "\n" + ENDDATA);
			break;
		case "Record Not Found":
			LOG.info("MailService::sendEmailToApplicants::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + DISAPPROVED + "\n" + RECORDNOTFOUND + "\n" + ENDDATA);
			break;
		default:
			LOG.info("MailService::sendOtpToUser::call sendMail method");
			this.sendMail(userEmail, APPLICATION_UPDATE_SUBJECT,
					WELCOME + "\n" + DISAPPROVED + "\n" + RECORDNOTFOUND + "\n" + ENDDATA);

		}

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
	}

	/**
	 * Send OTP to user on its email Address.
	 *
	 * @param userEmail
	 * @param otp
	 */
	public void sendOtpToUser(String userEmail, String otp) {
		LOG.info("MailService::sendOtpToUser::call sendMail method");
		this.sendMail(userEmail, OTPSUBJECT, OTPCONTENT + "\n" + otp + "\n" + ENDDATA);
		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
	}
}
