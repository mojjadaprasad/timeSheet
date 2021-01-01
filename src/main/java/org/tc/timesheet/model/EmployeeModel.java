package org.tc.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_mst_tbl")
public class EmployeeModel extends BaseEntity{


	private String name;
	private String status;
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
	
	
	private String address;
	private Date doj;
	private Date dob;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return super.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MAIL_ID")
	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		// TODO Auto-generated method stub
		return super.createdOn;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="AADHAR_NO")
	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Column(name="PAN_NO")
	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Column(name="PASSPOST_NO")
	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Column(name="ALT_MOBILE")
	public String getAltMobile() {
		return altMobile;
	}

	public void setAltMobile(String altMobile) {
		this.altMobile = altMobile;
	}

	@Column(name="EMG_MOBILE")
	public String getEmgMobile() {
		return emgMobile;
	}

	public void setEmgMobile(String emgMobile) {
		this.emgMobile = emgMobile;
	}

	@Column(name="ADDRESS",length=4000)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="DOJ")
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Column(name="DOB")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "EmployeeModel [name=" + name + ", status=" + status + ", mailId=" + mailId + ", mobile=" + mobile
				+ ", gender=" + gender + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", passportNo="
				+ passportNo + ", altMobile=" + altMobile + ", emgMobile=" + emgMobile + ", address=" + address
				+ ", doj=" + doj + ", dob=" + dob + ", id=" + id + ", createdOn=" + createdOn + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getMailId()=" + getMailId() + ", getMobile()=" + getMobile()
				+ ", getGender()=" + getGender() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getCreatedOn()=" + getCreatedOn() + ", getStatus()=" + getStatus()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getAadharNo()="
				+ getAadharNo() + ", getPanNo()=" + getPanNo() + ", getPassportNo()=" + getPassportNo()
				+ ", getAltMobile()=" + getAltMobile() + ", getEmgMobile()=" + getEmgMobile() + ", getAddress()="
				+ getAddress() + ", getDoj()=" + getDoj() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
