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
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService{
	
	@Autowired(required=true) 
	OrganizationApplicationRepository organizationApplication;
	
    @Autowired 
    CibilReportRepository cibilReport;

	@Autowired
	OrganizationRepository organization;
	
	

	public HashMap<String,Long> organizationRiskMitigate(OrganizationApplicant application){
		HashMap<String, Long> json = new HashMap<>();
		int bankrupcy;
		int cri;
		if(application.getBankruptcy()==null) {
			application.setBankruptcy(false);}
		if(application.getCriminalRecord()==null) {
			application.setCriminalRecord(false);
		}
		
		System.out.println(application.getBankruptcy());
		System.out.println(application.getCriminalRecord());
     // System.out.println(application.getLicenseNumber());
      //System.out.println(application.getPancard());
      try {
		CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
		System.out.println("before cibil ");
	application.setApplicationStatus(this.ApproveOrDisapprove(application.getBankruptcy(), application.getCriminalRecord(),
				reportOfCurrentUser.getCategory(), reportOfCurrentUser.getCreditScore(),
				application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
				reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
				reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance(),application.getLoanTenure(),reportOfCurrentUser.getAssetCost(),reportOfCurrentUser.getLiabilities()));
System.out.println("after cibil");
		
      }
      catch(Exception e)
      {
    	
    	//application.setApplicationStatus("");
    	  json.put("enter valid pan no", (long) 999999999);
    	  return json;
      }
      
System.out.println("userId: "+ (application.getUserId()).getUserId());
		
		//application.setApplicationStatus(this.ApproveOrDisapprove());
		Long userId = (application.getUserId()).getUserId();
		System.out.println("after userid");
		//Long orap=organizationApplication.getApplicationIdByUserId(userId);
		System.out.println("before orap");
//		if(orap==null) {
//		
		
		Long organizatinId = organization.getOrganizationIdByUserId(userId);
		System.out.println("inside null check");
		
	organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(), application.getCriminalRecord(), application.getEmployeeCount(), 
										application.getLicenseNumber(), application.getLoanAmount(),application.getLoanTenure(),application.getOrganizationType(),application.getPancard(),
										application.getRevenue(), application.getApplicationStatus(), organizatinId, userId);		
	
	System.out.println("Organization Application ID:"+ organizationApplication.getApplicationId());
 json = new HashMap<String,Long>();
	json.put("Application_Id",organizationApplication.getApplicationId());
	return json;
//	}
//		
//		else {
//			System.out.println("else part");
//			json.put("application already exist with applicaton id", orap);
//			return json;
//			
//		}

	}
	
	  public OrganizationApplicant  findByUserId(long userId) {
		  return findByUserId(userId);
		  
		  
	  }
	

	
	
	
	public String ApproveOrDisapprove(boolean bankrupt, boolean criminal, String assetCategory, int cibilScore, int loanAmount,
			float creditUtilization, float creditLimit, int monthlyIncome, float monthlyLiablities,
			float currentBalance,int loanTenure,float assetCost,float liabilites) {
		if (bankrupt == false || criminal == false) {
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
			float calculatedIncome=(float) (monthlyIncome*0.5);
			  float interest = (float) ((loanAmount*13.5*loanTenure)/1200);
			  float EMI= ((loanAmount+interest)/loanTenure); 
			  float assetvalue=assetCost-liabilites;
			float  loanamt=(float) (loanAmount+(assetvalue*0.2));
			
			  if (calculatedIncome>EMI) {
				  return "Approved";
			  }
			  else if(assetvalue>loanamt) {
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<OrganizationApplicant>getAllOrganizationApplicant(Integer pageNo, Integer pageSize){
        System.out.println("inside service impl");

		Pageable paging = PageRequest.of(pageNo, pageSize);
        System.out.println(paging);

        Page<OrganizationApplicant> pagedResult = organizationApplication.findAll(paging);
        System.out.println(pagedResult);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<OrganizationApplicant>();
        }
    }
	
	 public List<OrganizationApplicant> findApplicants() {
		   String emailStatus="False";
		   List<OrganizationApplicant> result= organizationApplication.findByemailStatus(emailStatus);
		   System.out.println("inside service");
		return result;
	}

	@Override
	public List<OrganizationApplicant> findTopPersonCreditors() {
		List<OrganizationApplicant>result=organizationApplication.findTopPersonCreditors();
		return result;
}
}