package org.tc.timesheet.dto;

import java.util.Date;

public class EmployeeDto extends BaseDto {

	
	private Long id;
	private String status;
	private String name;
	private String mailId;
	private String mobile;
	private String gender;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String aadharNo;
	private String panNo;
	private String passportNo;
	private String altMobile;
	private String emgMobile;

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
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getAltMobile() {
		return altMobile;
	}
	public void setAltMobile(String altMobile) {
		this.altMobile = altMobile;
	}
	public String getEmgMobile() {
		return emgMobile;
	}
	public void setEmgMobile(String emgMobile) {
		this.emgMobile = emgMobile;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return super.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Date getCreatedOn() {
		// TODO Auto-generated method stub
		return super.createdOn;
	}


	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", status=" + status + ", name=" + name + ", mailId=" + mailId + ", mobile="
				+ mobile + ", gender=" + gender + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", passportNo="
				+ passportNo + ", altMobile=" + altMobile + ", emgMobile=" + emgMobile + "]";
	}
	
	
	
}
