package com.impetus.controller;

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

import com.impetus.model.OrganizationApplicant;
import com.impetus.service.OrganizationApplicationService;

@RestController
public class OrganizationApplicationController {

	private static final Logger LOG = LoggerFactory.getLogger(OrganizationApplicationController.class);
	@Autowired(required = true)
	private OrganizationApplicationService organizationservice;
	@Autowired
	private OrganizationApplicationService service;

	/**
	 * Organization applicant application submit.
	 *
	 * @param application the application
	 * @return status and user id To save the application by organization applicant.
	 */

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/organization-user/user-application")
	public Map<String, String> organizationApplicantApplicationSubmit(@RequestBody OrganizationApplicant application) {
		LOG.info(
				"OrganizationApplicationController ::organizationApplicantApplicationSubmit::return to organizationRiskMitigate ");
		return service.organizationRiskMitigate(application);

	}

	/**
	 * find out all application associated with particular userId.
	 *
	 * @param userId
	 * @return list of Organization Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/organization-user/user-history")
	public List<OrganizationApplicant> organizationHistory(@RequestBody OrganizationApplicant userId) {

		LOG.info("OrganizationApplicationController ::organizationHistory::return to getHistory method with userId"
				+ userId);

		return service.getHistory(userId);

	}

	/**
	 * get organization applications in particular page with no of records.
	 *
	 * @param pageNo
	 * @param pageSize
	 * @return list of Organization Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getOrganizationApplicants")
	public List<OrganizationApplicant> getAllOrganizationApplicant() {
		LOG.info(
				"OrganizationApplicationController ::getAllOrganizationApplicant::return to getAllOrganizationApplicant method");
		return organizationservice.getAllOrganizationApplicant();
	}

	/**
	 * find out top creditors.
	 * 
	 * @return list of Organization Applicants
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getTopOrganizationApplicants")
	public List<OrganizationApplicant> findTopPersonCreditors() {
		LOG.info("OrganizationApplicationController ::findTopPersonCreditors::return to findTopPersonCreditors method");
		return organizationservice.findTopPersonCreditors();

	}

}