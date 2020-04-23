package com.impetus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "cibil_Report")
@Table(name = "cibil_Report")
@EntityListeners(AuditingEntityListener.class)
public class CibilReport {

	@Id
	@Column(name = "pan_Card", nullable = false)
	@Size(max = 10)
	private String panCard;

	@Column(name = "credit_Score", nullable = false)
	private int creditScore;

	@Column(name = "asset_Cost", nullable = false)
	private float assetCost;

	@Column(name = "liabilities", nullable = false)
	private float liabilities;

	@Column(name = "bankruptcies", nullable = false)
	private boolean bankruptcies;

	@Column(name = "contact_Number", nullable = false)
	private Long contactNumber;

	@Column(name = "monthly_Income", nullable = false)
	private int monthlyIncome;

	// balance yet to pay to the lending institutions
	@Column(name = "current_Balance", nullable = false)
	private float currentBalance;

	// STD, NPA, SUB https://www.coverfox.com/cibil/cibil-report/
	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "repayment_Tenure", nullable = false)
	private float repaymentTenure;

	@Column(name = "credit_Limit", nullable = false)
	private float creditLimit;

	@Column(name = "credit_Utilization", nullable = false)
	private float creditUtilization; // if it is more than 70% of credit limit == then we wont give loan

	/**
	 * @return the panCard
	 */
	public String getPanCard() {
		return panCard;
	}

	/**
	 * @param panCard the panCard to set
	 */
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	/**
	 * @return the assetCost
	 */
	public float getAssetCost() {
		return assetCost;
	}

	/**
	 * @param assetCost the assetCost to set
	 */
	public void setAssetCost(float assetCost) {
		this.assetCost = assetCost;
	}

	/**
	 * @return the liabilities
	 */
	public float getLiabilities() {
		return liabilities;
	}

	/**
	 * @param liabilities the liabilities to set
	 */
	public void setLiabilities(float liabilities) {
		this.liabilities = liabilities;
	}

	/**
	 * @return the bankruptcies
	 */
	public boolean isBankruptcies() {
		return bankruptcies;
	}

	/**
	 * @param bankrupties the bankruptcies to set
	 */
	public void setBankruptcies(boolean bankruptcies) {
		this.bankruptcies = bankruptcies;
	}

	/**
	 * @return the contactNumber
	 */
	public Long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the monthlyIncome
	 */
	public int getMonthlyIncome() {
		return monthlyIncome;
	}

	/**
	 * @param monthlyIncome the monthlyIncome to set
	 */
	public void setMonthlyIncome(int monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	/**
	 * @return the currentBalance
	 */
	public float getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the repaymentTenure
	 */
	public float getRepaymentTenure() {
		return repaymentTenure;
	}

	/**
	 * @param repaymentTenure the repaymentTenure to set
	 */
	public void setRepaymentTenure(float repaymentTenure) {
		this.repaymentTenure = repaymentTenure;
	}

	/**
	 * @return the creditLimit
	 */
	public float getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return the creditUtilization
	 */
	public float getCreditUtilization() {
		return creditUtilization;
	}

	/**
	 * @param creditUtilization the creditUtilization to set
	 */
	public void setCreditUtilization(float creditUtilization) {
		this.creditUtilization = creditUtilization;
	}

}
