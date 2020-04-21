package com.impetus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.PersonApplicant;
import com.impetus.service.PersonApplicationService;

@RestController
public class PersonApplicationController {

	@Autowired
	PersonApplicationService service;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/individual-user/user-application")
	public HashMap<String, Long> personApplicantApplicationSubmit(@RequestBody PersonApplicant application) {

//    	service.RiskMitigate(application);
//    	System.out.println("controller transfered to service");
		return service.RiskMitigate(application);

	}

	/**
	 * find person applications corresponding to particular Id
	 *
	 * @param userID
	 * 
	 * @param Integer
	 * 
	 * @return list of Person Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/individual-user/user-history")
	public List<PersonApplicant> personHistory(@RequestBody PersonApplicant userId) {

//    	service.RiskMitigate(application);
//    	System.out.println("controller transfered to service");
		return service.getHistory(userId);

	}

	/**
	 * find person applications corresponding to particular Id
	 *
	 * @param userID
	 * 
	 * @param Integer
	 * 
	 * @return list of person Applicants
	 */

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getPersonApplicants")
	public List<PersonApplicant> getAllPersonApplicant(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "1") int pageSize) {
		System.out.println(pageNo);
		return service.getAllPersonApplicant(pageNo, pageSize);

	}

	/**
	 * find top creditors
	 * 
	 * @return list of Person Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getTopPersonApplicants")
	public List<PersonApplicant> findTopPersonCreditors() {
		return service.findTopPersonCreditors();

	}

}
