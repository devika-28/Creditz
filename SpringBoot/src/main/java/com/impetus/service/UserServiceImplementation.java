package com.impetus.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;
import com.impetus.repository.RegistrationRepository;

@Service
public class UserServiceImplementation implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImplementation.class);
	@Autowired
	private RegistrationRepository userdao;
	@Autowired
	private MailService notificationService;
	static final String APPPLICATION_SUBJECT = "Email OTP Verification";
	static final String APPPLICATION = "Hello,\nThank you for registering with Creditz\nPlease verify your OTP.\nYour OTP is : ";

	/**
	 * generate the six digit opt and return in string form.
	 * 
	 * @return OTP, in string form
	 * @throws NoSuchAlgorithmException
	 */
	public String generateOTP() throws NoSuchAlgorithmException {
		String numbers = "0123456789";
		StringBuilder finalotp = new StringBuilder();
		Random r = SecureRandom.getInstanceStrong();
		char[] otp = new char[6];
		for (int i = 0; i < otp.length; i++) {
			otp[i] = numbers.charAt(r.nextInt(numbers.length()));
			finalotp.append(otp[i]);

		}
		LOG.info("UserServiceImplementation::generateOTP::otp generated for registration");
		return "" + finalotp;
	}

	/**
	 * send OTP.
	 * 
	 * @param userEmail the userEmail
	 * @return OTP, in string form
	 * @throws NoSuchAlgorithmException
	 */
	public String sendOTP(String userEmail) throws NoSuchAlgorithmException {

		String otp = this.generateOTP();
		LOG.info(" UserServiceImplementation ::sendOTP::call sendMail method with user Email{}", userEmail);
		notificationService.sendMail(userEmail, APPPLICATION_SUBJECT, APPPLICATION + otp);
		return otp;
	}

	/**
	 * Save person.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Transactional
	@Override
	public boolean savePerson(Person user) {
		User user1 = user.getUser();
		user1.setPassword(hashPassword(user1.getPassword()));
		user.setUser(user1);
		return userdao.savePerson(user);
	}

	/**
	 * * @param user the user
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean saveOrganization(Organization user) {
		User user1 = user.getUser();
		user1.setPassword(hashPassword(user1.getPassword()));
		user.setUser(user1);
		return userdao.saveOrganization(user);
	}

	/**
	 * encrypt the password.
	 *
	 * @param plainTextPassword
	 * @return String
	 */
	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	/**
	 * Save Analyst.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	public boolean saveAnalyst(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		return userdao.saveAnalyst(user);
	}

	/**
	 * @return formattedDate
	 */
	public static String getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		LOG.info("UserServiceImplementation ::sendOTP::Current time of the day using Calendar-24 hour format:{}",
				formattedDate);
		return formattedDate;
	}

	/**
	 * @return time
	 */
	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		LOG.info("UserServiceImplementation ::sendOTP::Current time of the day using Calendar-24 hour format:{}", date);
		return formatter.format(date);
	}

}
