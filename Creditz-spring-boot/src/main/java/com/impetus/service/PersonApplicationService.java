package com.impetus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.PersonApplicant;

@Service
public interface PersonApplicationService {

	public HashMap<String, Long> RiskMitigate(PersonApplicant application);

	/**
	 * find person applications in particular page with no of records
	 *
	 * @param Integer
	 * 
	 * @param Integer
	 * 
	 * @return list of Person Applicants
	 */

	public List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize);

	/**
	 * @return list of Person Applicants
	 */

	public List<PersonApplicant> findApplicants();

	/**
	 * find top creditors
	 * 
	 * @return list of Person Applicants
	 */

	public List<PersonApplicant> findTopPersonCreditors();

	/**
	 * find person applications corresponding to particular Id
	 *
	 * @param userID
	 * 
	 * @param Integer
	 * 
	 * @return list of Person Applicants
	 */
	List<PersonApplicant> getHistory(PersonApplicant userId);

}