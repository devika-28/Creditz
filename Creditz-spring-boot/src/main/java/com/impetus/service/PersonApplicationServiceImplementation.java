package com.impetus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

@Service
public class PersonApplicationServiceImplementation implements PersonApplicationService {

	static final String APPROVED = "Approved";
	static final String FALSE = "False";
	@Autowired
	private CibilReportRepository cibilReport;

	@Autowired
	private PersonApplicationRepository personApplication;

	@Autowired
	private PersonRepository person;

	/**
	 * process the submitted application and calculate the risk.
	 * 
	 * @param application user application
	 * @return hash map consisting of application ID
	 */
	@Override
	public HashMap<String, Long> riskMitigate(PersonApplicant application) {

		try {
			CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());

			application.setApplicationStatus(this.approveOrDisapprove(application, reportOfCurrentUser));

		} catch (Exception e) {
			application.setApplicationStatus("Record Not Found");
		}

		Long userId = (application.getUserId()).getUserId();

		Long personId = person.getPersonIdByUserId(userId);

		application.setEmailStatus(FALSE);

		personApplication.insertApplication(application.getPancard(), application.getLoanAmount(), application.getAge(),
				application.getGender(), application.getOccupation(), application.getApplicationStatus(),
				application.getCriminalRecord(), application.getBankruptcy(), application.getLoanTenure(), personId,
				userId, application.getEmailStatus());

		HashMap<String, Long> json = new HashMap<>();
		json.put("Application_Id", personApplication.getApplicationId());
		return json;
	}

	/**
	 * function to calculate approve or disapprove.
	 * 
	 * @param bankrupt
	 * @param criminal
	 * @param assetCategory
	 * @param cibilScore
	 * @param loanAmount
	 * @param creditUtilization
	 * @param creditLimit
	 * @param monthlyIncome
	 * @param monthlyLiablities
	 * @param currentBalance
	 * @return status
	 */
	public String approveOrDisapprove(PersonApplicant application, CibilReport reportOfCurrentUser) {

		if (application.getBankruptcy() == 1 || application.getCriminalRecord() == 1) {
			return "Rejected";
		}

		else if (!(reportOfCurrentUser.getCategory().equals("STD")
				|| !(reportOfCurrentUser.getCategory().equals("NPA")))) {
			return "Rejected Bad History";
		}

		else if (reportOfCurrentUser.getCreditScore() < 550 && reportOfCurrentUser.getCreditScore() >= 300) {
			return "Rejected Low Credits";
		}

		else if (reportOfCurrentUser.getCreditScore() < 700 && reportOfCurrentUser.getCreditScore() >= 550) {
			int limit = 500000;
			return validation(limit, application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
					reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
					reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance());
		}

		else if (reportOfCurrentUser.getCreditScore() < 800 && reportOfCurrentUser.getCreditScore() >= 700) {
			int limit = 1000000;
			return validation(limit, application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
					reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
					reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance());
		}

		else if (reportOfCurrentUser.getCreditScore() <= 900 && reportOfCurrentUser.getCreditScore() >= 800) {
			return "Approve";
		}

		return "Pending Internal Error";
	}

	/**
	 * validation function.
	 * 
	 * @param limit
	 * @param loanAmount
	 * @param creditUtilization
	 * @param creditLimit
	 * @param monthlyIncome
	 * @param monthlyLiablities
	 * @param currentBalance
	 * @return status
	 */
	public String validation(int limit, int loanAmount, float creditUtilization, float creditLimit, int monthlyIncome,
			float monthlyLiablities, float currentBalance) {

		if (loanAmount > limit) {
			return "Rejected Amount Declined";
		}

		else if (creditUtilization <= .4 * creditLimit) {
			return "Rejected Bad History";
		}

		else if (.25 * (monthlyIncome + monthlyLiablities) <= loanAmount && currentBalance < loanAmount / 2) {
			return "Approve";
		}

		return "Pending Internal Error";
	}

	/**
	 * find person applications corresponding to particular Id.
	 *
	 * @param userId
	 * @return list of Person Applicants
	 */

	@Override
	public List<PersonApplicant> getHistory(PersonApplicant userId) {

		return (List<PersonApplicant>) personApplication.findByUserId((userId.getUserId()).getUserId());
	}

	/**
	 * find person applications in particular page with no of records.
	 *
	 * @param pageNo
	 * @param pageSize
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<PersonApplicant> pagedResult = personApplication.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<>();
		}
	}

	/** @return list of Person Applicants */
	public List<PersonApplicant> findApplicants() {

		return personApplication.findByemailStatus(FALSE);

	}

	/**
	 * find top creditors.
	 * 
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> findTopPersonCreditors() {
		return personApplication.findTopPersonCreditors(APPROVED);
	}

}
