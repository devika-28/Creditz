package com.impetus.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService userService; // Service which will do all data retrieval/manipulation work

	/**
	 * login function
	 * 
	 * @return Hash map containing role and user id of current user
	 */
	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, String>> login() {

		SecurityContext context = SecurityContextHolder.getContext();
		HashMap<String, String> users = (java.util.HashMap<String, String>) userService
				.PostLoginDetails(context.getAuthentication().getName());
		if (users.isEmpty()) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.NO_CONTENT);// You many decide to return
																						// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<HashMap<String, String>>(users, HttpStatus.OK);
	}

}