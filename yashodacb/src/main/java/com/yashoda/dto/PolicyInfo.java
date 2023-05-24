package com.yashoda.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PolicyInfo {
	private int policyNo;
	private int planNo;
	private String planName;
	private int memberNo;
	private String policyHolderName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date policyStartDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date policyEndDate;
	private double premiumAmount;
	private double insurredAmount;
	private String status;
	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getPolicyStartDate() {
		return policyStartDate;
	}
	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}
	public Date getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public double getInsurredAmount() {
		return insurredAmount;
	}
	public void setInsurredAmount(double insurredAmount) {
		this.insurredAmount = insurredAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PolicyInfo [policyNo=" + policyNo + ", planNo=" + planNo + ", planName=" + planName + ", memberNo="
				+ memberNo + ", policyHolderName=" + policyHolderName + ", dob=" + dob + ", gender=" + gender
				+ ", policyStartDate=" + policyStartDate + ", policyEndDate=" + policyEndDate + ", premiumAmount="
				+ premiumAmount + ", insurredAmount=" + insurredAmount + ", status=" + status + "]";
	}
	public PolicyInfo(int policyNo, int planNo, String planName, int memberNo, String policyHolderName, Date dob,
			String gender, Date policyStartDate, Date policyEndDate, double premiumAmount, double insurredAmount,
			String status) {
		super();
		this.policyNo = policyNo;
		this.planNo = planNo;
		this.planName = planName;
		this.memberNo = memberNo;
		this.policyHolderName = policyHolderName;
		this.dob = dob;
		this.gender = gender;
		this.policyStartDate = policyStartDate;
		this.policyEndDate = policyEndDate;
		this.premiumAmount = premiumAmount;
		this.insurredAmount = insurredAmount;
		this.status = status;
	}
	public PolicyInfo() {
		super();
	}
	
	
	
	
	
	
}
