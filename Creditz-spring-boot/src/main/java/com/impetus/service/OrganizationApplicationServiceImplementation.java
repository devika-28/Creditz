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
import com.impetus.model.OrganizationApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.OrganizationRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService {
 
                     static final String APPLICATIONSTATUS="Approved";
                     static final String EMAILSTATUS = "False";

	@Autowired(required = true)
	OrganizationApplicationRepository organizationApplication;

	@Autowired
	CibilReportRepository cibilReport;

	@Autowired
	OrganizationRepository organization;

	public HashMap<String, Long> organizationRiskMitigate(OrganizationApplicant application) {
		HashMap<String, Long> json = new HashMap<>();

		System.out.println(application.getBankruptcy());
		System.out.println(application.getCriminalRecord());
		try {
			CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
			System.out.println("before cibil ");
			application.setApplicationStatus(this.ApproveOrDisapprove(application.getBankruptcy(),
					application.getCriminalRecord(), reportOfCurrentUser.getCategory(),
					reportOfCurrentUser.getCreditScore(), application.getLoanAmount(),
					reportOfCurrentUser.getCreditUtilization(), reportOfCurrentUser.getCreditLimit(),
					reportOfCurrentUser.getMonthlyIncome(), reportOfCurrentUser.getLiabilities(),
					reportOfCurrentUser.getCurrentBalance(), application.getLoanTenure(),
					reportOfCurrentUser.getAssetCost(), reportOfCurrentUser.getLiabilities()));
			System.out.println("after cibil");

		} catch (Exception e) {

			application.setApplicationStatus("record not found");

		}

		System.out.println("userId: " + (application.getUserId()).getUserId());

		// application.setApplicationStatus(this.ApproveOrDisapprove());
		Long userId = (application.getUserId()).getUserId();
		System.out.println("after userid");
		// Long orap=organizationApplication.getApplicationIdByUserId(userId);
		System.out.println("before orap");
//		if(orap==null) {
//		
		// Long personId = person.getPersonIdByUserId(userId);
		Long organizatinId = organization.getOrganizationIdByUserId(userId);
		System.out.println(organizatinId);
		System.out.println("inside null check");

		application.setEmailStatus("False");
		System.out.println(application.getBankruptcy());
		System.out.println(application.getBusinessAge());
		System.out.println(application.getCriminalRecord());
		System.out.println(application.getEmployeeCount());
		System.out.println(application.getLicenseNumber());
		System.out.println(application.getLoanAmount());
		System.out.println(application.getLoanTenure());
		System.out.println(application.getOrganizationType());
		System.out.println(application.getPancard());
		System.out.println(application.getApplicationStatus());
		System.out.println(organizatinId);
		System.out.println(application.getEmailStatus());

		organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(),
				application.getCriminalRecord(), application.getEmployeeCount(), application.getLicenseNumber(),
				application.getLoanAmount(), application.getLoanTenure(), application.getOrganizationType(),
				application.getPancard(), application.getRevenue(), application.getApplicationStatus(), organizatinId,
				userId, application.getEmailStatus());

		System.out.println("Organization Application ID:" + organizationApplication.getApplicationId());
		json = new HashMap<String, Long>();
		json.put("Application_Id", organizationApplication.getApplicationId());
		return json;

	}

	public OrganizationApplicant findByUserId(long userId) {
		return findByUserId(userId);

	}

	public String ApproveOrDisapprove(int bankrupt, int criminal, String assetCategory, int cibilScore, int loanAmount,
			float creditUtilization, float creditLimit, int monthlyIncome, float monthlyLiablities,
			float currentBalance, int loanTenure, float assetCost, float liabilites) {
		if (bankrupt == 1 || criminal == 1) {
			return "Rejected";
		}

		else if (assetCategory != "STD" || assetCategory != "NPA") {
			return "Rejected Bad History"; // of repayment
		}

		else if (cibilScore < 500 && cibilScore >= 300) {
			return "Rejected Low Credits";
		}

		else if (cibilScore <= 900 && cibilScore >= 700) {
			return "Approve";
		}

		else if (creditUtilization >= 60) {
			return "Rejected Bad History";
		}

		else if (cibilScore < 700 && cibilScore >= 500) {
//			int limit = 500000;
//			return validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome, monthlyLiablities,
//					currentBalance);
			float calculatedIncome = (float) (monthlyIncome * 0.5);
			float interest = (float) ((loanAmount * 13.5 * loanTenure) / 1200);
			float EMI = ((loanAmount + interest) / loanTenure);
			float assetvalue = assetCost - liabilites;
			float loanamt = (float) (loanAmount + (assetvalue * 0.2));

			if (calculatedIncome > EMI) {
				return "Approved";
			} else if (assetvalue > loanamt) {
				return "Approved";
			}
		}

//		else if (cibilScore < 800 && cibilScore >= 700) {
//			int limit = 1000000;
//			return validation(limit, loanAmount, creditUtilization, creditLimit, monthlyIncome, monthlyLiablities,
//					currentBalance);
//		}

		return "Pending Internal Error";
	}

//	public String validation(int limit, int loanAmount, float creditUtilization, float creditLimit, int monthlyIncome,
//			float monthlyLiablities, float currentBalance) {
//		if (loanAmount > limit) {
//			return "Rejected Amount Declined";
//		}
//
//		else if (creditUtilization >= .4 * creditLimit) {
//			return "Rejected Bad History";
//		}

	/**
	 * find out all application associated with particular userId
	 *
	 * @param userId
	 * 
	 * @return list of Organization Applicants
	 */
	@Override
	public List<OrganizationApplicant> getHistory(OrganizationApplicant userId) {

		List<OrganizationApplicant> application = (List<OrganizationApplicant>) organizationApplication
				.findByUserId((userId.getUserId()).getUserId());

//		personApplication.findByUserId(userId.getUserId());

		System.out.println(application.get(0));

		return application;
	}

	/**
	 * get organization applications in particular page with no of records
	 *
	 * @param Integer
	 * 
	 * @param Integer
	 * 
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize) {
		System.out.println("inside service impl");

		Pageable paging = PageRequest.of(pageNo, pageSize);
		System.out.println(paging);

		Page<OrganizationApplicant> pagedResult = organizationApplication.findAll(paging);
		System.out.println(pagedResult);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<OrganizationApplicant>();
		}
	}

	/**
	 * @return list of Organization Applicants
	 */
	public List<OrganizationApplicant> findApplicants() {
		
		List<OrganizationApplicant> result = organizationApplication.findByemailStatus(EMAILSTATUS);
		System.out.println("inside service");
		return result;
	}

	/**
	 * find out top creditors
	 * 
	 * @return list of Organization Applicants
	 */
	@Override
	public List<OrganizationApplicant> findTopPersonCreditors() {
		List<OrganizationApplicant> result = organizationApplication.findTopPersonCreditors(APPLICATIONSTATUS);
		return result;
	}
}