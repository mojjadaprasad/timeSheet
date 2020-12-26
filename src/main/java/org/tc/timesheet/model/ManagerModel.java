package org.tc.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager_mst_tbl")
public class ManagerModel  extends BaseEntity {

	
	private String name;
	private String mailId;
	private String status;

	@Id
	@Override
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
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
	
	@Override
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		// TODO Auto-generated method stub
		return super.createdOn;
	}


	
	@Column(name="STATUS")
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
