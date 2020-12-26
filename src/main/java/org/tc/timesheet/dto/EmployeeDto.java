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
		return "EmployeeModel [name=" + name + ", mailId=" + mailId + ", mobile=" + mobile + ", gender=" + gender
				+ ", userName=" + userName + ", password=" + password + ", id=" + id + ", createdOn=" + createdOn
				+ ", status=" + status + "]";
	}
	
	
}
