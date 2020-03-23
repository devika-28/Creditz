package com.impetus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organizationapplicant")
public class OrganizationApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;

    /** The panCard */
    @Size(max = 10)
    @Column(name = "pan_card", nullable = false)
    private String pancard;
    
    /** Loan Amount */
    @Column(name = "loan_amount", nullable = false)
    private int loanAmount;

    /** Revenue of Organization */
    @Column(name = "revenue", nullable = false)
    private long revenue;

    /** No of Employees in Organization */
    @Column(name = "employee_count", nullable = false)
    private int employeeCount;

    /** the no years business is running */
    @Column(name = "age", nullable = false)
    private int businessAge;
    
	/** license no of organization */
    @Column(name = "licenseno", nullable = false)
    private String licenseNumber;

    /** field of organization */
    @Column(name = "organization_type", nullable = false)
    private String organizationType;

    /** application status approved or pending or approved */
    @Column(name = "application_status", nullable = false)
    private String applicationStatus;

    /** Criminal record against applicant */
    @Column(name = "criminal_record", nullable = false)
    private Boolean criminalRecord;

    /** is applicant is bankCorrupt */
    @Column(name = "bankruptcy", nullable = false)
    private Boolean bankruptcy;

    /**
     *loan tenure
     */
    @Column(name = "loan_tenure", nullable = false)
    private int loanTenure;
    /**
     * 
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organizationId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;


    public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public int getBusinessAge() {
		return businessAge;
	}

	public void setBusinessAge(int businessAge) {
		this.businessAge = businessAge;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Boolean getCriminalRecord() {
		return criminalRecord;
	}

	public void setCriminalRecord(Boolean criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	public Boolean getBankruptcy() {
		return bankruptcy;
	}

	public void setBankruptcy(Boolean bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}


    
    
}
