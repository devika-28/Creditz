package com.impetus.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

@Service
public class PersonApplicationServiceImplementation implements PersonApplicationService{

	@Autowired CibilReportRepository cibilReport;
	
	@Autowired PersonApplicationRepository personApplication;
	
	@Autowired PersonRepository person;
	
	@Override
	public HashMap<String,Long> RiskMitigate(PersonApplicant application) {

		CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
		System.out.println(reportOfCurrentUser);
		
		System.out.println(reportOfCurrentUser.getAssetCost());
		System.out.println(reportOfCurrentUser.getCategory());
//		application.getLoanAmount();
//		application.getAge();
//		application.getBankruptcy();
//		application.getCriminalRecord();
//		application.getLoanTenure();
//		application.getApplicationStatus();
//		reportOfCurrentUser.getAssetCost();
//		reportOfCurrentUser.getCategory();
//		reportOfCurrentUser.getCreditLimit();
//		reportOfCurrentUser.getCreditScore();
//		reportOfCurrentUser.getCreditUtilization();
//		reportOfCurrentUser.getCurrentBalance();
//		reportOfCurrentUser.getLiabilities();
//		reportOfCurrentUser.getMonthlyIncome();

		System.out.println("userId: "+ (application.getUserId()).getUserId());
		
		application.setApplicationStatus(this.ApproveOrDisapprove());
		Long userId = (application.getUserId()).getUserId();
		
		Long personId = person.getPersonIdByUserId(userId);
		
	personApplication.insertApplication(application.getPancard(), application.getLoanAmount(), application.getAge(), application.getGender(), 
										application.getOccupation(), application.getApplicationStatus(), application.getCriminalRecord(), 
										application.getBankruptcy(), application.getLoanTenure(), personId, userId);		
	
	System.out.println("Person Application ID:"+ personApplication.getApplicationId());
	HashMap<String,Long> json = new HashMap<String,Long>();
	json.put("Application_Id", personApplication.getApplicationId());
	return json;
	}
	
	

	public String ApproveOrDisapprove() {
		
		return "approve";
	}

}
