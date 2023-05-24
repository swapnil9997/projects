package com.athena.insurance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PolicyDetailsDto {
	private int policyNo;
	private int planNo;
	private String planName;
	private int memberNo;
	private String policyHolderName;
	private LocalDate dob;
	private String gender;
	private LocalDate policyStartDate;
	private LocalDate policyEndDate;
	private double premiumAmount;
	private double insurredAmount;
	private String status;
	public PolicyDetailsDto(int policyNo, int planNo, String planName, int memberNo, String policyHolderName,
			LocalDate dob, String gender, LocalDate policyStartDate, LocalDate policyEndDate, double premiumAmount,
			double insurredAmount, String status) {
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
	public PolicyDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PolicyDetailsDto [policyNo=" + policyNo + ", planNo=" + planNo + ", planName=" + planName
				+ ", memberNo=" + memberNo + ", policyHolderName=" + policyHolderName + ", dob=" + dob + ", gender="
				+ gender + ", policyStartDate=" + policyStartDate + ", policyEndDate=" + policyEndDate
				+ ", premiumAmount=" + premiumAmount + ", insurredAmount=" + insurredAmount + ", status=" + status
				+ "]";
	}
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getPolicyStartDate() {
		return policyStartDate;
	}
	public void setPolicyStartDate(LocalDate policyStartDate) {
		this.policyStartDate = policyStartDate;
	}
	public LocalDate getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(LocalDate policyEndDate) {
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

	
	
	
	
	
	
}
