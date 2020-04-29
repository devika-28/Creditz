package com.impetus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.User;
import com.impetus.security.HttpBasicAuthenticationHeader;
import com.impetus.service.AnalystService;

@RestController
public class AnalystController {

	private static final Logger LOG = LoggerFactory.getLogger(AnalystController.class);
	@Autowired
	private AnalystService service;

	/**
	 * get Details of all Analyst.
	 * 
	 * @return List of all Analyst
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getAllAnalyst")
	public List<User> getAllAnalyst(){
		LOG.info("AnalystController::getAllAnalyst::call getAllAnalyst method");
		return service.getAllAnalyst();

	}

	/**
	 * delete Analyst details corresponding to particular userEmail.
	 *
	 * @param userEmail
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAnalyst")
	public void deleteAnalyst(@RequestParam String userEmail) {
		LOG.info("AnalystController::getAllAnalyst::call deleteAnalyst method with userEmail" + userEmail);
		service.deleteAnalyst(userEmail);

	}

	/**
	 * check is there any User corresponding to particular email Address.
	 *
	 * @param userEmail
	 * @return User
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/checkUniqueUser")
	public User uniqueEmailCheck(@RequestParam String userEmail) {
		LOG.info("AnalystController::uniqueEmailCheck::call uniqueCheckEmail method with userEmail{}"
				+ "" + userEmail);
		return service.uniqueCheckEmail(userEmail);
	}

	/**
	 * send one time password to userEmail.
	 *
	 * @param userEmail the user email
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getOtp")
	public String sendOtp(String userEmail) {
		LOG.info("AnalystController::uniqueEmailCheck::call sendOtp method with userEmail:{}",userEmail);
		return service.sendOtp(userEmail);
	}

	/**
	 * update the user password of particular user.
	 *
	 * @param users the user
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/updateUserPassword")
	public boolean updateUserPassword(@RequestBody String auth) {
		LOG.info("AnalystController::updateUserPassword::call updateUserPassword method");
		return service.updateUserPassword(auth);
	}

	/**
	 * Find User on the basis of userEmail and password.
	 *
	 * @param userEmail
	 * @param password
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/verifyUser")
	public User findUser(@RequestBody String auth) {
		HttpBasicAuthenticationHeader http = new HttpBasicAuthenticationHeader();
		auth = http.decoder(auth);
		LOG.info("AnalystController::findUser::call findUserByEmailPassword method");
		return service.findUserByEmailPassword(auth.split(":")[0], auth.split(":")[1]);
	}
}
