package com.impetus.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.User;
import com.impetus.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	// search employee start with name

	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param User
	 * 
	 * @return hash map if user Exist
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String, String> login(@RequestBody User login) {
		@SuppressWarnings("unchecked")
		HashMap<String, String> credentials = (HashMap<String, String>) loginService.isValidUser(login);
		return credentials;
	}

}
