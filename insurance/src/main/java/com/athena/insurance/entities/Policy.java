package com.athena.insurance.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Neosoft
 *
 */
@Entity
@Table(name = "policy")
@Data
public class Policy implements Serializable {
	private static final long serialVersionUID = 3290619895615514222L;
	@Id
	@Column(name = "policy_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policyNo;
	@Column(name = "member_no")
	private int memberNo;
	private int tenure;
	@Column(name = "premium_amount")
	private double premiumAmount;
	@Column(name = "insurred_amount")
	private double insurredAmount;
	@Column(name = "policy_start_dt")
	private LocalDate policyStartDate;
	@Column(name = "policy_end_dt")
	private LocalDate policyEndDate;
	@Column(name = "registered_mobile_no")
	private String registeredMobileNo;
	private String status;

	@ManyToOne
	@JoinColumn(name = "plan_no")
	private Plan plan;

	@Override
	public String toString() {
		return "Policy [policyNo=" + policyNo + ", memberNo=" + memberNo + ", tenure=" + tenure + ", premiumAmount="
				+ premiumAmount + ", insurredAmount=" + insurredAmount + ", policyStartDate=" + policyStartDate
				+ ", policyEndDate=" + policyEndDate + ", registeredMobileNo=" + registeredMobileNo + ", status="
				+ status + ", plan=" + plan + "]";
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(int policyNo, int memberNo, int tenure, double premiumAmount, double insurredAmount,
			LocalDate policyStartDate, LocalDate policyEndDate, String registeredMobileNo, String status, Plan plan) {
		super();
		this.policyNo = policyNo;
		this.memberNo = memberNo;
		this.tenure = tenure;
		this.premiumAmount = premiumAmount;
		this.insurredAmount = insurredAmount;
		this.policyStartDate = policyStartDate;
		this.policyEndDate = policyEndDate;
		this.registeredMobileNo = registeredMobileNo;
		this.status = status;
		this.plan = plan;
	}

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
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

	public String getRegisteredMobileNo() {
		return registeredMobileNo;
	}

	public void setRegisteredMobileNo(String registeredMobileNo) {
		this.registeredMobileNo = registeredMobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
