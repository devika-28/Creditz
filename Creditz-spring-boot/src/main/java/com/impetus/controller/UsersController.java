package com.impetus.controller;

import java.util.List;

import org.jboss.logging.Logger;
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
import com.impetus.service.UsersService;

@RestController
public class UsersController {

	static final Logger LOGGER = Logger.getLogger("UserController");
	@Autowired
	private UsersService service;

	/**
	 * get Details of all Analyst.
	 *
	 * @param pageNo
	 * @param pageSize
	 * @return List of all Analyst
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getAllAnalyst")
	public List<User> getAllAnalyst(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "1") int pageSize) {
		return service.getAllAnalyst(pageNo, pageSize);

	}

	/**
	 * delete Analyst details corresponding to particular userEmail.
	 *
	 * @param userEmail
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAnalyst")
	public void deleteAnalyst(@RequestParam String userEmail) {
		LOGGER.info("Delete Request Arrived .");
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
		return service.findUserByEmailPassword(auth.split(":")[0], auth.split(":")[1]);
	}
}
