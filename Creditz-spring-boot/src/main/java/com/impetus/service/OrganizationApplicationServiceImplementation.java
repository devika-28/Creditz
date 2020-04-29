package com.impetus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.OrganizationApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.OrganizationRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrganizationApplicationServiceImplementation.class);
	static final String APPROVED = "Approved";
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
	public HashMap<String, String> organizationRiskMitigate(OrganizationApplicant application) {
		HashMap<String, String> json = null;
		Date applicationdate = null;
		int noOfApplication;
		String nextapplicationdate;
		Long userId = (application.getUserId()).getUserId();
		Long organizatinId = organization.getOrganizationIdByUserId(userId);
		List<OrganizationApplicant> list = organizationApplication.findByUserId(userId);
		noOfApplication = list.size();
		if (noOfApplication > 0) {
			String lastApplicationDate = list.get(noOfApplication - 1).getDate();
			String lastapplicationstatus = list.get(noOfApplication - 1).getApplicationStatus();
			if (!(lastapplicationstatus.equals(REJECTED))) {
				try {
					applicationdate = new SimpleDateFormat("dd/MM/yyyy").parse(lastApplicationDate);
				} catch (ParseException e) {
					LOG.info("string to date parsing problem");
				}
				if (applicationdate != null) {
					nextapplicationdate = this.getNextApplicationDate(applicationdate);
					json = new HashMap<>();
					json.put("Application_Id",
							"Already submitted application \nYou can submit your next applcation after "
									+ nextapplicationdate + "\nThank You");
					return json;
				} else {
					LOG.error("no applications yet");
				}
			}
		} else {
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
			application.setDate(UserServiceImplementation.getCurrentDate());
			application.setTime(UserServiceImplementation.getCurrentTime());
			application.setEmailStatus(EMAILSTATUS);
			organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(),
					application.getCriminalRecord(), application.getEmployeeCount(), application.getLicenseNumber(),
					application.getLoanAmount(), application.getLoanTenure(), application.getOrganizationType(),
					application.getPancard(), application.getRevenue(), application.getApplicationStatus(),
					organizatinId, userId, application.getEmailStatus(), application.getDate(), application.getTime());
			json = new HashMap<>();
			json.put("Application_Id",
					"Thanks!\nYour Application is being taken into consideration\nWe will inform you Sooner\nYour Application Id is: "
							+ organizationApplication.getApplicationId());
			return json;
		}
		return json;
	}

	/**
	 * this will calculate and return to submit application after 6months
	 * 
	 * @param appdate
	 * @return
	 */

	String getNextApplicationDate(Date appdate) {
		int day;
		int month;
		int year;
		String nextdate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(appdate);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		month = calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);
		month += 6;
		if (month > 12) {
			month %= 12;
			year += 1;
		}
		nextdate = day + "-" + month + "-" + year;
		return nextdate;
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
		if (loanAmount > 7000000 || bankrupt == 1 || criminal == 1) {
			return REJECTED;
		} else if (!(assetCategory.equals("STD")) || assetCategory.equals("NPA") || creditUtilization >= 60) {
			return REJECTEDBADHISTORY;
		} else if (cibilScore < 500 && cibilScore >= 300) {
			return REJECTEDLOWCREDITS;
		} else if (cibilScore <= 900 && cibilScore >= 700) {
			return APPROVED;
		} else if (cibilScore < 700 && cibilScore >= 500) {
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


	
}