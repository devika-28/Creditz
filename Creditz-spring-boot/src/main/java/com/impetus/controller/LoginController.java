package com.impetus.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.service.LoginService;

@RestController
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService userService;

	/**
	 * login function.
	 * 
	 * @return Hash map containing role and user id of current user
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/login")
	public ResponseEntity<HashMap<String, String>> login() {

		SecurityContext context = SecurityContextHolder.getContext();
		HashMap<String, String> users = (java.util.HashMap<String, String>) userService
				.postLoginDetails(context.getAuthentication().getName());
		try {
			if (users.isEmpty()) {
				LOG.info("LoginController :: login::user does not exist");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			LOG.info("LoginController :: login::RunTimeException", e);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}