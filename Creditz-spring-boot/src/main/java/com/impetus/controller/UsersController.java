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
import com.impetus.service.UsersService;

/**
 * @author pia jaiswal
 *
 */
@RestController
public class UsersController {

	Logger logger = Logger.getLogger("UserController");
	@Autowired
	UsersService service;

	/**
	 * get Details of all Analyst
	 *
	 * @param pageno
	 * 
	 * @param pagesize
	 * 
	 * @return List of all Analyst
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getAllAnalyst")
	public List<User> getAllAnalyst(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "1") int pageSize) {
		System.out.println(pageNo);
		return service.getAllAnalyst(pageNo, pageSize);

	}

	/**
	 * delete Analyst details corresponding to particular userEmail
	 *
	 * @param userEmail
	 *
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAnalyst")
	void deleteAnalyst(@RequestParam String userEmail) {
		logger.info("Delete Request Arrived .");
		service.DeleteAnalyst(userEmail);

	}

	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param userEmail
	 * 
	 * @return User
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/checkUniqueUser")
	User uniqueEmailCheck(@RequestParam String userEmail) {
		return service.uniqueCheckEmail(userEmail);
	}

	/**
	 * send one time password to userEmail
	 *
	 * @param user the user
	 * 
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getOtp")
	public String sendOtp(String userEmail) {
		return service.sendOtp(userEmail);
	}

	/**
	 * update the user password of particular user
	 *
	 * @param user the user
	 * 
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/updateUserPassword")
	public boolean updateUserPassword(@RequestBody User users) {
		return service.updateUserPassword(users);
	}

	/**
	 * Find User on the basis of userEmail and password
	 *
	 * @param userEmail
	 * 
	 * @param password
	 * 
	 * @return true, if successful
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/findUserByEmailAndPassword")
	public User findUser(@RequestParam String userEmail, @RequestParam String password) {
		System.out.println(service.findUserByEmailPassword(userEmail, password));
		return service.findUserByEmailPassword(userEmail, password);
	}
}
