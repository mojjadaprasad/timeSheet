package org.tc.timesheet.dto;

import java.util.Date;

import javax.persistence.Column;

import org.tc.timesheet.model.BaseEntity;

public class ManagerDto extends BaseDto {

	private Long id;
	private String name;
	private String mailId;
	private String status;


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
		return "ManagerModel [name=" + name + ", mailId=" + mailId + ", id=" + id + ", createdOn=" + createdOn
				+ ", status=" + status + "]";
	}
}
