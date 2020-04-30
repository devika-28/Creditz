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
	static final String DATEFORMAT = "dd/MM/yyyy";
	static final String REJECTEDLOWCREDITS = "Rejected Low Credits";
	static final String REJECTED = "Rejected";
	static final String PENDING = "Pending";
	static final String RECORDNOTFOUND = "Record Not Found";
	static final String REJECTEDBADHISTORY = "Rejected Bad History";
	static final String EMAILSTATUS = "False";
	static final String REJECTEDEARLY = "Rejected Early";

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
	 * @throws ParseException
	 */
	public HashMap<String, Long> organizationRiskMitigate(OrganizationApplicant application) throws ParseException {
		LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Evaluating Policy");

		HashMap<String, Long> json = null;
		Long userId = (application.getUserId()).getUserId();
		Long organizatinId = organization.getOrganizationIdByUserId(userId);

		CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
		LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Fetching CIBIL Records");

		if (reportOfCurrentUser != null) {
			LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::CIBIL Records, Fetched");

			application.setDate(UserServiceImplementation.getCurrentDate());
			application.setTime(UserServiceImplementation.getCurrentTime());

			application.setApplicationStatus(this.approveOrDisapprove(application, reportOfCurrentUser));
			LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Application Status SET");
		} else {
			LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::CIBIL Record not found");

			application.setApplicationStatus(RECORDNOTFOUND);
		}
		application.setEmailStatus(EMAILSTATUS);
		LOG.info(
				"OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Inserting Data into database");
		organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(),
				application.getCriminalRecord(), application.getEmployeeCount(), application.getLicenseNumber(),
				application.getLoanAmount(), application.getLoanTenure(), application.getOrganizationType(),
				application.getPancard(), application.getRevenue(), application.getApplicationStatus(), organizatinId,
				userId, application.getEmailStatus(), application.getDate(), application.getTime());
		LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Data inserted Succesfully");

		json = new HashMap<>();
		LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Fetching Application ID");
		json.put("Application_Id", organizationApplication.getApplicationId());
		LOG.info(
				"OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Return Application ID to controller");
		return json;

	}

	/**
	 * this will calculate and return to submit application after 6months
	 * 
	 * @param appdate
	 * @return
	 * @throws ParseException
	 */

	String checkdate(Date lastApplicationdate, String currentApplicationdate) throws ParseException {
		int daylast;
		int monthlast;
		int yearlast;
		Date currentdate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastApplicationdate);
		daylast = calendar.get(Calendar.DAY_OF_MONTH);
		monthlast = calendar.get(Calendar.MONTH);
		yearlast = calendar.get(Calendar.YEAR);

		monthlast += 6;
		if (monthlast > 12) {
			monthlast %= 12;
			yearlast += 1;
		}
		lastApplicationdate = new SimpleDateFormat(DATEFORMAT).parse(daylast + "/" + monthlast + "/" + yearlast);

		currentdate = new SimpleDateFormat(DATEFORMAT).parse(currentApplicationdate);

		if (lastApplicationdate.after(currentdate)) {

			return REJECTEDEARLY;
		}
		return null;
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
	 * @throws ParseException
	 */

	public String approveOrDisapprove(OrganizationApplicant application, CibilReport reportOfCurrentUser)
			throws ParseException {
		String nextapplicationStatus;
		String assetCategory = reportOfCurrentUser.getCategory();
		int cibilScore = reportOfCurrentUser.getCreditScore();
		int loanAmount = application.getLoanAmount();
		int monthlyIncome = reportOfCurrentUser.getMonthlyIncome();
		int loanTenure = application.getLoanTenure();
		float assetCost = reportOfCurrentUser.getAssetCost();
		float liabilites = reportOfCurrentUser.getLiabilities();
		Long userId = (application.getUserId()).getUserId();
		int noOfApplication;
		Date applicationdate;
		List<OrganizationApplicant> list = organizationApplication.findByUserId(userId);
		noOfApplication = list.size();

		if (noOfApplication > 0) {
			String lastApplicationDate = list.get(noOfApplication - 1).getDate();

			applicationdate = new SimpleDateFormat(DATEFORMAT).parse(lastApplicationDate);

			if (applicationdate != null) {

				nextapplicationStatus = this.checkdate(applicationdate, application.getDate());
				if (nextapplicationStatus.equals(REJECTEDEARLY)) {
					return REJECTEDEARLY;
				}
			} else {
				LOG.info("date formating error");
			}
		}

		if (loanAmount > 7000000 || application.getBankruptcy() == 1 || application.getCriminalRecord() == 1) {
			return REJECTED;
		} else if (!(assetCategory.equals("STD")) || assetCategory.equals("NPA")
				|| reportOfCurrentUser.getCreditUtilization() >= 60) {
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
			if (calculatedIncome > emi || assetvalue > loanamt) {
				return APPROVED;
			}
		}

		return "Pending Internal Error";

	}

	/**
	 * find out top creditors.
	 * 
	 * @return list of Organization Applicants
	 */
	@Override
	public List<OrganizationApplicant> findTopPersonCreditors() {
		LOG.info(
				"OrganizationApplicationServiceImplementation::findApplicants::call findByemailStatus method with email Status:{}",
				EMAILSTATUS);
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
		LOG.info(
				"OrganizationApplicationServiceImplementation::getHistory::call findByemailStatus method with findByUserId:{}",
				(userId.getUserId()).getUserId());
		return organizationApplication.findByUserId((userId.getUserId()).getUserId());
	}

	/**
	 * get organization applications
	 * 
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> getAllOrganizationApplicant() {
		LOG.info(
				"OrganizationApplicationServiceImplementation::getAllOrganizationApplicant::call findAll method with email Status:{0},EMAILSTATUS ");
		return organizationApplication.findAll();

	}

	/** @return list of Organization Applicants */
	public List<OrganizationApplicant> findApplicants() {

		return organizationApplication.findByemailStatus(EMAILSTATUS);

	}

}