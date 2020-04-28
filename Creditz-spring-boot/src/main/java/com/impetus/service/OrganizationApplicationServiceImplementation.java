package com.impetus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static final String APPROVED = "Approved";
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

    /** @param application
     * @return Application id string and value of application id */
    public Map<String, Long> organizationRiskMitigate(OrganizationApplicant application) {
        HashMap<String, Long> json;

        try {
            CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
            application.setApplicationStatus(this.approveOrDisapprove(application.getBankruptcy(), application.getCriminalRecord(),
                    reportOfCurrentUser.getCategory(), reportOfCurrentUser.getCreditScore(), application.getLoanAmount(),
                    reportOfCurrentUser.getCreditUtilization(), reportOfCurrentUser.getMonthlyIncome(),
                    application.getLoanTenure(),
                    reportOfCurrentUser.getAssetCost(), reportOfCurrentUser.getLiabilities()));

        } catch (Exception e) {

            application.setApplicationStatus("record not found");

        }

        Long userId = (application.getUserId()).getUserId();
        Long organizatinId = organization.getOrganizationIdByUserId(userId);

        application.setEmailStatus(EMAILSTATUS);
        organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(), application.getCriminalRecord(),
                application.getEmployeeCount(), application.getLicenseNumber(), application.getLoanAmount(), application.getLoanTenure(),
                application.getOrganizationType(), application.getPancard(), application.getRevenue(), application.getApplicationStatus(),
                organizatinId, userId, application.getEmailStatus());

        json = new HashMap<>();
        json.put("Application_Id", organizationApplication.getApplicationId());
        return json;

    }

    public OrganizationApplicant findByUserId(long userId) {
        return findByUserId(userId);

    }

    public String approveOrDisapprove(int bankrupt, int criminal, String assetCategory, int cibilScore, int loanAmount, float creditUtilization,
            int monthlyIncome, int loanTenure, float assetCost, float liabilites) {
        if (bankrupt == 1 || criminal == 1) {
            return "Rejected";
        }

        else if (!(assetCategory.equals("STD") || !(assetCategory.equals("NPA")))) {
            return "Rejected Bad History";
        }

        else if (cibilScore < 500 && cibilScore >= 300) {
            return "Rejected Low Credits";
        }

        else if (cibilScore <= 900 && cibilScore >= 700) {
            return APPROVED;
        }

        else if (creditUtilization >= 60) {
            return "Rejected Bad History";
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

    /** find out all application associated with particular userId.
     *
     * @param userId
     * @return list of Organization Applicants */
    @Override
    public List<OrganizationApplicant> getHistory(OrganizationApplicant userId) {

        return (List<OrganizationApplicant>) organizationApplication.findByUserId((userId.getUserId()).getUserId());
    }

    /** get organization applications in particular page with no of records.
     *
     * @param pageNo
     * @param pageSize
     * @return list of Organization Applicants */
    public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<OrganizationApplicant> pagedResult = organizationApplication.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    /** @return list of Organization Applicants */
    public List<OrganizationApplicant> findApplicants() {

        return organizationApplication.findByemailStatus(EMAILSTATUS);

    }

    /** find out top creditors.
     * 
     * @return list of Organization Applicants */
    @Override
    public List<OrganizationApplicant> findTopPersonCreditors() {
        return organizationApplication.findTopPersonCreditors(APPROVED);
    }
}