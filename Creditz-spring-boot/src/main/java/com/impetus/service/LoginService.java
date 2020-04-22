package com.impetus.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param userEmail
	 * 
	 * @return hash map if user Exist
	 */
	public HashMap<?, ?> PostLoginDetails(String userEmail);

}
