package com.impetus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

@Service
public class PersonApplicationServiceImplementation implements PersonApplicationService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonApplicationServiceImplementation.class);
	static final String APPROVED = "Approved";
	static final String FALSE = "False";
	static final String REJECTED = "Rejected";
	static final String RECORDNOTFOUND = "Record Not Found";
	static final String DATEFORMAT = "dd/MM/yyyy";
	static final String REJECTEDEARLY = "Rejected Early";
	static final String REJECTEDLOWCREDITS = "Rejected Low Credits";
	static final String REJECTEDLIMIT = "Invalid Limit";
	static final String PENDING = "Pending";
	static final String REJECTEDBADHISTORY = "Rejected Bad History";
	static final String EMAILSTATUS = "False";

	@Autowired
	private CibilReportRepository cibilReport;

	@Autowired
	private PersonApplicationRepository personApplication;

	@Autowired
	private PersonRepository person;

	@Autowired
	private OrganizationApplicationServiceImplementation organizationApplication;

	/**
	 * process the submitted application and calculate the risk.
	 * 
	 * @param application user application
	 * @return hash map consisting of application ID
	 */
	@Override
	public Map<String, Long> riskMitigate(PersonApplicant application) throws ParseException {
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Evaluating Policy");

		HashMap<String, Long> json = null;
		Long userId = (application.getUserId()).getUserId();
		Long personId = person.getPersonIdByUserId(userId);
		application.setDate(UserServiceImplementation.getCurrentDate());
		application.setTime(UserServiceImplementation.getCurrentTime());
		 if((application.getLoanAmount()<1500000 && application.getLoanAmount()> 10000) && (application.getLoanTenure()<100 && application.getLoanTenure()>3))
 		{
		CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Fetching CIBIL Records");
		if (reportOfCurrentUser != null) {
			LOG.info("PersonApplicationServiceImplementation ::riskMitigate::CIBIL Records, Fetched");
			application.setApplicationStatus(this.approveOrDisapprove(application, reportOfCurrentUser));
			LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Application Status SET");
		} else {
			LOG.info("PersonApplicationServiceImplementation ::riskMitigate::CIBIL Record not found");
			application.setApplicationStatus(RECORDNOTFOUND);
		}
 		}
		 else {
	        	
	        	LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Not in verified range of loan amount or tenure");
	            application.setApplicationStatus(REJECTEDLIMIT);
	        }
		application.setEmailStatus(FALSE);
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Inserting Data into database");
		personApplication.insertApplication(application.getPancard(), application.getLoanAmount(), application.getAge(),
				application.getGender(), application.getOccupation(), application.getApplicationStatus(),
				application.getCriminalRecord(), application.getBankruptcy(), application.getLoanTenure(), personId,
				userId, application.getEmailStatus(), application.getDate(), application.getTime());
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Data inserted Succesfully");

		json = new HashMap<>();
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Fetching Application ID");
		json.put("Application_Id", personApplication.getApplicationId());
		LOG.info("PersonApplicationServiceImplementation ::riskMitigate::Return Application ID to controller");
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
	 * @throws ParseException
	 */
	public String approveOrDisapprove(PersonApplicant application, CibilReport reportOfCurrentUser)
			throws ParseException {
		LOG.info("PersonApplicationServiceImplementation ::approveOrDisapprove::Setting application status");

		String nextapplicationStatus;
		Long userId = (application.getUserId()).getUserId();
		int noOfApplication;
		Date applicationdate;
		
		List<PersonApplicant> list = personApplication.findByUserId(userId);
		noOfApplication = list.size();
		if (noOfApplication > 0) {
			String lastApplicationDate = list.get(noOfApplication - 1).getDate();
			 if(!(list.get(noOfApplication - 1).getApplicationStatus().equals(REJECTEDLIMIT))) {
			applicationdate = new SimpleDateFormat(DATEFORMAT).parse(lastApplicationDate);

			if (applicationdate != null) {

				nextapplicationStatus = organizationApplication.checkdate(applicationdate, application.getDate());
				if (nextapplicationStatus.equals(REJECTEDEARLY)) {
					LOG.info("PersonApplicationServiceImplementation ::approveOrDisapprove::Application Status Set");
					return REJECTEDEARLY;
				}
			} else {
				LOG.info("date formating error");
			}
			 }
		}

		if (application.getBankruptcy() == 1 || application.getCriminalRecord() == 1) {
			return REJECTED;
		}

		else if (!(reportOfCurrentUser.getCategory().equals("STD"))
				|| (reportOfCurrentUser.getCategory().equals("NPA"))) {
			return REJECTEDBADHISTORY;
		}

		else if (reportOfCurrentUser.getCreditScore() < 550 && reportOfCurrentUser.getCreditScore() >= 300) {
			return REJECTEDLOWCREDITS;
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
			return APPROVED;
		}

		return PENDING;
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
		LOG.info("PersonApplicationServiceImplementation ::validation::Validating User, and setting status");

		if (loanAmount > limit) {
			return REJECTEDLOWCREDITS;
		}

		else if (creditUtilization <= .4 * creditLimit) {
			return REJECTEDBADHISTORY;
		}

		else if (.25 * (monthlyIncome + monthlyLiablities) <= loanAmount && currentBalance < loanAmount / 2) {
			return APPROVED;
		}

		return PENDING;
	}

	/**
	 * find person applications corresponding to particular Id.
	 *
	 * @param userId
	 * @return list of Person Applicants
	 */

	@Override
	public List<PersonApplicant> getHistory(PersonApplicant userId) {
		LOG.info(" PersonApplicationServiceImplementation::getHistory::call findByUserId method with UserId:{}",
				(userId.getUserId()).getUserId());
		return personApplication.findByUserId((userId.getUserId()).getUserId());
	}

	/**
	 * find person applications
	 *
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> getAllPersonApplicant() {
		LOG.info("PersonApplicationServiceImplementation::getAllPersonApplicant::call findAll");
		return personApplication.findAll();

	}

	/** @return list of Person Applicants */
	public List<PersonApplicant> findApplicants() {
		LOG.info("PersonApplicationServiceImplementation::findApplicants::call findByemailStatus method");
		return personApplication.findByemailStatus(FALSE);

	}

	/**
	 * find top creditors.
	 * 
	 * @return list of Person Applicants
	 */
	public List<PersonApplicant> findTopPersonCreditors() {
		LOG.info("PersonApplicationServiceImplementation::findTopPersonCreditors::call findTopPersonCreditors method");
		return personApplication.findTopPersonCreditors(APPROVED);
	}

}