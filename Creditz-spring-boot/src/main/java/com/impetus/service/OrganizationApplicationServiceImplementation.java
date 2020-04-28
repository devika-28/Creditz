package com.impetus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.OrganizationApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.OrganizationRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService {

	static final String APPROVED = "Approved";

	static final String DISAPPROVED = "Rejected";
	static final String REJECTEDLOWCREDITS = "Rejected Low Credits";
	static final String REJECTED = "Rejected";
	static final String PENDING = "Pending";
	static final String RECORDNOTFOUND = "Record Not Found";
	static final String REJECTEDBADHISTORY = "Rejected Bad History";
	static final String EMAILSTATUS = "False";
	/** the organization application */
	@Autowired(required = true)
	private OrganizationApplicationRepository organizationApplication;

	/** the CIBIL report */
	@Autowired
	private CibilReportRepository cibilReport;

	/** the organization */
	@Autowired
	private OrganizationRepository organization;

	/**
	 * @param application
	 * @return Application id string and value of application id
	 */
	public HashMap<String, Long> organizationRiskMitigate(OrganizationApplicant application) {
		HashMap<String, Long> json;

		try {
			CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
			application.setApplicationStatus(
					this.approveOrDisapprove(application.getBankruptcy(), application.getCriminalRecord(),
							reportOfCurrentUser.getCategory(), reportOfCurrentUser.getCreditScore(),
							application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
							reportOfCurrentUser.getMonthlyIncome(), application.getLoanTenure(),
							reportOfCurrentUser.getAssetCost(), reportOfCurrentUser.getLiabilities()));

		} catch (Exception e) {

			application.setApplicationStatus("record not found");

		}

		Long userId = (application.getUserId()).getUserId();
		Long organizatinId = organization.getOrganizationIdByUserId(userId);
		application.setDate(UserServiceImplementation.getCurrentDate());
		application.setTime(UserServiceImplementation.getCurrentTime());
		System.out.println(UserServiceImplementation.getCurrentDate());
		System.out.println(UserServiceImplementation.getCurrentTime());

		application.setEmailStatus(EMAILSTATUS);
		organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(),
				application.getCriminalRecord(), application.getEmployeeCount(), application.getLicenseNumber(),
				application.getLoanAmount(), application.getLoanTenure(), application.getOrganizationType(),
				application.getPancard(), application.getRevenue(), application.getApplicationStatus(), organizatinId,
				userId, application.getEmailStatus(), application.getDate(), application.getTime());

		json = new HashMap<>();
		json.put("Application_Id", organizationApplication.getApplicationId());
		return json;

	}

	/**
	 * find organization applicant by user id
	 * 
	 * @param userId
	 * @return organization applicant
	 */
	public OrganizationApplicant findByUserId(long userId) {
		return findByUserId(userId);

	}

	/**
	 * approve or disapprove
	 * 
	 * @param bankrupt
	 * @param criminal
	 * @param assetCategory
	 * @param cibilScore
	 * @param loanAmount
	 * @param creditUtilization
	 * @param monthlyIncome
	 * @param loanTenure
	 * @param assetCost
	 * @param liabilites
	 * @return value for application status approved or other .
	 */

	public String approveOrDisapprove(int bankrupt, int criminal, String assetCategory, int cibilScore, int loanAmount,
			float creditUtilization, int monthlyIncome, int loanTenure, float assetCost, float liabilites) {

		if (loanAmount > 7500000 || bankrupt == 1 || criminal == 1) {
			return REJECTED;
		}

		else if (!(assetCategory.equals("STD")) || !(assetCategory.equals("NPA")) || creditUtilization >= 60) {
			System.out.println("histry");
			return REJECTEDBADHISTORY;
		}

		else if (cibilScore < 500 && cibilScore >= 300) {
			return REJECTEDLOWCREDITS;
		}

		else if (cibilScore <= 900 && cibilScore >= 700) {
			return APPROVED;
		}

		else if (cibilScore < 700 && cibilScore >= 500) {
			float calculatedIncome = (float) (monthlyIncome * 0.5);
			float interest = (float) ((loanAmount * 13.5 * loanTenure) / 1200);
			float emi = ((loanAmount + interest) / loanTenure);
			float assetvalue = assetCost - liabilites;
			float loanamt = (float) (loanAmount + (assetvalue * 0.2));

			if (calculatedIncome > emi) {
				return APPROVED;
			} else if (assetvalue > loanamt)
				return APPROVED;
		}

		return "Pending Internal Error";
	}

	/**
	 * find out all application associated with particular userId.
	 *
	 * @param userId
	 * @return list of Organization Applicants
	 */
	@Override
	public List<OrganizationApplicant> getHistory(OrganizationApplicant userId) {

		return organizationApplication.findByUserId((userId.getUserId()).getUserId());
	}

	/**
	 * get organization applications
	 * 
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> getAllOrganizationApplicant() {

		return organizationApplication.findAll();

	}

	/** @return list of Organization Applicants */
	public List<OrganizationApplicant> findApplicants() {

		return organizationApplication.findByemailStatus(EMAILSTATUS);

	}

	/**
	 * find out top creditors.
	 * 
	 * @return list of Organization Applicants
	 */
	@Override
	public List<OrganizationApplicant> findTopPersonCreditors() {
		return organizationApplication.findTopPersonCreditors(APPROVED);
	}
}