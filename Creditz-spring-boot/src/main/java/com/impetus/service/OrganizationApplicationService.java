package com.impetus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.OrganizationApplicant;

@Service
public interface OrganizationApplicationService {
	/**
	 * get organization applications in particular page with no of records
	 *
	 * @param Integer
	 * 
	 * @param Integer
	 * 
	 * @return list of Organization Applicants
	 */

	public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize);

	/**
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> findApplicants();

	/**
	 * find out top creditors
	 * 
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> findTopPersonCreditors();

	/**
	 * Organization risk Mitigate
	 * @param application
	 * @return HashMap<String, Long> containing string Application id and its value in long
	 * decides whether to approve or reject the application
	 */
	public HashMap<String, Long> organizationRiskMitigate(OrganizationApplicant application);

	/**
	 * find out all application associated with particular userId
	 *
	 * @param userId
	 * 
	 * @return list of Organization Applicants
	 */
	List<OrganizationApplicant> getHistory(OrganizationApplicant userId);

}
