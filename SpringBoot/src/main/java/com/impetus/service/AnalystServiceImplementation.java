package com.impetus.service;

import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.User;
import com.impetus.repository.UserRepository;
import com.impetus.security.HttpBasicAuthenticationHeader;

@Service
public class AnalystServiceImplementation implements AnalystService {

	private static final Logger LOG = LoggerFactory.getLogger(AnalystServiceImplementation.class);
	@Autowired
	private UserRepository user;

	@Autowired
	private MailService notificationService;

	/**
	 * get Details of all Analyst.
	 * 
	 * @return List of all Analyst
	 */
	@Override
	public List<User> getAllAnalyst() {
		String role = "Analyst";
		LOG.info("AnalystServiceImplementation::getAllAnalyst::call findByRole method with role:{}",role);
        return user.findByRole(role);
		
	}

	/**
	 * delete Analyst details corresponding to particular userEmail.
	 *
	 * @param userEmail
	 */
	public void deleteAnalyst(String userEmail) {
		LOG.info("AnalystServiceImplementation::deleteAnalyst::call findByUserEmail method with user email:{}",userEmail);
		user.delete(user.findByUserEmail(userEmail));
		LOG.info("AnalystServiceImplementation::deleteAnalyst::Delete user successfully with userEmail{}", userEmail);
	}

	/**
	 * check is there any User corresponding to particular email Address.
	 *
	 * @param userEmail
	 * @return User
	 */
	public User uniqueCheckEmail(String userEmail) {
		LOG.info("AnalystServiceImplementation::uniqueCheckEmail::call findByUserEmail method with user email:{}",userEmail);
		return user.findByUserEmail(userEmail);

	}

	/**
	 * generate One Time Password.
	 *
	 * @return String
	 */
	@Override
	public String generateOtp() {
		String numbers = "123456789";
		Random r = new Random();
		char otp[] = new char[5];
		for (int i = 0; i < otp.length; i++) {
			otp[i] = numbers.charAt(r.nextInt(numbers.length()));
		}
		return new String(otp);
	}

	/**
	 * send one time password to userEmail.
	 *
	 * @param userEmail the user
	 * @return true, if successful
	 */
	@Override
	public String sendOtp(String userEmail) {
		LOG.info("AnalystServiceImplementation::sendOtp::call generateOtp method");
		String otp = this.generateOtp();
		LOG.info("AnalystServiceImplementation::sendOtp::call sendOtpToUser method with user email:{}",userEmail);
		notificationService.sendOtpToUser(userEmail, otp);
		return otp;
	}

	/**
	 * update the user password of particular user.
	 *
	 * @param users the user
	 * @return true, if successful
	 */
	@Override
	public boolean updateUserPassword(String auth) {
		boolean ans = false;
		HttpBasicAuthenticationHeader http = new HttpBasicAuthenticationHeader();
		auth = http.decoder(auth);
		try {
			user.updatePassword(auth.split(":")[0], hashPassword(auth.split(":")[1]));
			ans = true;
			return ans;
		} catch (Exception e) {
			return ans;
		}
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	/**
	 * Find User on the basis of userEmail and password.
	 *
	 * @param userEmail
	 * @param password
	 * @return true, if successful
	 */
	@Override
	public User findUserByEmailPassword(String userEmail, String password) {
		User dummyuser = new User();
		LOG.info("AnalystServiceImplementation::sendOtp::call findByUserEmail method with user email:{}",userEmail);
		User user1 = user.findByUserEmail(userEmail);
		if (BCrypt.checkpw(password, user1.getPassword())) {
			return user1;
		}
		return dummyuser;
	}

}
