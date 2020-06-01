package com.impetus.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.PersonApplicant;
import com.impetus.service.PersonApplicationService;

@RestController
public class PersonApplicationController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonApplicationController.class);
	@Autowired
	private PersonApplicationService service;

	/**
	 * Function to calculate risk on the basis of persons application.
	 * 
	 * @param application Person application
	 * @return set the risk status into database
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/individual-user/user-application")
	public Map<String, Long> personApplicantApplicationSubmit(@RequestBody PersonApplicant application) {
		LOG.info("PersonApplicationController::personApplicantApplicationSubmit::return to riskMitigate method");
		try {
			return service.riskMitigate(application);
		} catch (ParseException e) {
			LOG.info("date formate parsing exception");
		}
		return null;

	}

	/**
	 * find person applications corresponding to particular Id.
	 *
	 * @param userId
	 * @return list of Person Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/individual-user/user-history")
	public List<PersonApplicant> personHistory(@RequestBody PersonApplicant userId) {
		LOG.info("PersonApplicationController::personHistory::return to getHistory with userId{}", userId);

		return service.getHistory(userId);

	}

	/**
	 * find all person applicants.
	 *
	 * @return list of person Applicants
	 */

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getPersonApplicants")
	public List<PersonApplicant> getAllPersonApplicant() {
		LOG.info("PersonApplicationController::getAllPersonApplicant::return to getAllPersonApplicant method");
		return service.getAllPersonApplicant();

	}

	/**
	 * find top creditors.
	 * 
	 * @return list of Person Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getTopPersonApplicants")
	public List<PersonApplicant> findTopPersonCreditors() {
		LOG.info("PersonApplicationController::findTopPersonCreditors::return to findTopPersonCreditors method");
		return service.findTopPersonCreditors();

	}

}
