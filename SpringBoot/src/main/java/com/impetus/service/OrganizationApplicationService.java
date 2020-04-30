package com.impetus.service;

import java.util.Map;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.OrganizationApplicant;

@Service
public interface OrganizationApplicationService {
	/**
	 * get organization applications
	 * 
	 * @return list of Organization Applicants
	 */

	List<OrganizationApplicant> getAllOrganizationApplicant();

	/** @return list of Organization Applicants */
	List<OrganizationApplicant> findApplicants();

	/**
	 * find out top creditors.
	 * 
	 * @return list of Organization Applicants
	 */
	List<OrganizationApplicant> findTopPersonCreditors();

	/**
	 * Organization risk Mitigate.
	 * 
	 * @param application
	 * @return Application id and its value in long decides whether to approve or
	 *         reject the application
	 */
	Map<String, Long> organizationRiskMitigate(OrganizationApplicant application) throws ParseException;

	/**
	 * find out all application associated with particular userId.
	 *
	 * @param userId
	 * @return list of Organization Applicants
	 */
	List<OrganizationApplicant> getHistory(OrganizationApplicant userId);

}
