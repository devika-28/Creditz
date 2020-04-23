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

                    static final String APPLICATIONSTATUS="Approved";
                    static final String EMAILSTATUS = "False";
	@Autowired
	CibilReportRepository cibilReport;

	@Autowired
	PersonApplicationRepository personApplication;

	@Autowired
	PersonRepository person;

	@Override
	public HashMap<String, Long> RiskMitigate(PersonApplicant application) {

		try {
			CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());

			application.setApplicationStatus(
					this.ApproveOrDisapprove(application.getBankruptcy(), application.getCriminalRecord(),
							reportOfCurrentUser.getCategory(), reportOfCurrentUser.getCreditScore(),
							application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
							reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
							reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance()));
		} catch (Exception e) {
//			LOG.info("cibil record not found");
			application.setApplicationStatus("Record Not Found");
		}

		Long userId = (application.getUserId()).getUserId();

		Long personId = person.getPersonIdByUserId(userId);

		application.setEmailStatus("False");

		personApplication.insertApplication(application.getPancard(), application.getLoanAmount(), application.getAge(),
				application.getGender(), application.getOccupation(), application.getApplicationStatus(),
				application.getCriminalRecord(), application.getBankruptcy(), application.getLoanTenure(), personId,
				userId, application.getEmailStatus());

		System.out.println("Person Application ID:" + personApplication.getApplicationId());
		HashMap<String, Long> json = new HashMap<String, Long>();
		json.put("Application_Id", personApplication.getApplicationId());
		return json;
	}

	public String ApproveOrDisapprove(int bankrupt, int criminal, String assetCategory, int cibilScore, int loanAmount,
			float creditUtilization, float creditLimit, int monthlyIncome, float monthlyLiablities,
			float currentBalance) {
		if (bankrupt == 1 || criminal == 1) {
			return "Rejected";
		}

		else if (assetCategory != "STD" || assetCategory != "NPA") {
			return "Rejected Bad History"; // of repayment
		}

		else if (cibilScore < 550 && cibilScore >= 300) {
			return "Rejected Low Credits";
		}

		else if (cibilScore < 700 && cibilScore >= 550) {
			int limit = 500000;
			return validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome, monthlyLiablities,
					currentBalance);
		}

		else if (cibilScore < 800 && cibilScore >= 700) {
			int limit = 1000000;
			return validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome, monthlyLiablities,
					currentBalance);
		}

		else if (cibilScore <= 900 && cibilScore >= 800) {
			return "Approve";
		}

		return "Pending Internal Error";
	}

	public String validation(int limit, int loanAmount, float creditUtilization, float creditLimit, int monthlyIncome,
			float monthlyLiablities, float currentBalance) {
		if (loanAmount > limit) {
			return "Rejected Amount Declined";
		}

		else if (creditUtilization >= .4 * creditLimit) {
			return "Rejected Bad History";
		}

		else if (.25 * (monthlyIncome + monthlyLiablities) <= loanAmount && currentBalance < loanAmount / 2) {
			return "Approve";
		}

		return "Pending Internal Error";
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

	@Override
	public List<PersonApplicant> getHistory(PersonApplicant userId) {

		List<PersonApplicant> application = (List<PersonApplicant>) personApplication
				.findByUserId((userId.getUserId()).getUserId());

//		personApplication.findByUserId(userId.getUserId());

		System.out.println(application);
		return application;
	}

	/**
	 * find person applications in particular page with no of records
	 *
	 * @param Integer
	 * 
	 * @param Integer
	 * 
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<PersonApplicant> pagedResult = personApplication.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<PersonApplicant>();
		}
	}

	/**
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> findApplicants() {
		
		List<PersonApplicant> result = personApplication.findByemailStatus(EMAILSTATUS);
		System.out.println("inside service");
		return result;

	}

	/**
	 * find top creditors
	 * 
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> findTopPersonCreditors(APPLICATIONSTATUS) {
		List<PersonApplicant> result = personApplication.findTopPersonCreditors();
		return result;
	}

}
