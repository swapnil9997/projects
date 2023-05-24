package com.athena.insurance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDto {
	private int memberNo;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String mobileNo;
	private String emailAddress;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "MemberDto [memberNo=" + memberNo + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress + "]";
	}
	public MemberDto(int memberNo, String firstName, String lastName, LocalDate dob, String gender, String mobileNo,
			String emailAddress) {
		super();
		this.memberNo = memberNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
	}
	public MemberDto() {
		super();
	}
	
	
	
	
	
}
