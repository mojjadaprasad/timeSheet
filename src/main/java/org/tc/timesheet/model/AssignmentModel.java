package org.tc.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "assignment_mst_tbl")
public class AssignmentModel extends BaseEntity{

	
	private EmployeeModel employee;
	private String status;
	private ManagerModel manager;
	private Date fromDate;
	private Date toDate;
	private String task;
	private String projectName;
	private String weekEnds;

	@Column(name="WEEKENDS")
	public String getWeekEnds() {
		return weekEnds;
	}

	
	public void setWeekEnds(String weekEnds) {
		this.weekEnds = weekEnds;
	}

	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return super.id;
	}


	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	public ManagerModel getManager() {
		return manager;
	}

	public void setManager(ManagerModel manager) {
		this.manager = manager;
	}

	@Column(name = "FROM_DATE")
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "TO_DATE")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "TASK")
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Column(name = "PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	@Override
	@Column(name="CREATED_ON")
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
		return "AssignmentModel [empployee=" + employee + ", manager=" + manager + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", task=" + task + ", projectName=" + projectName + ", weekEnds=" + weekEnds + ", id=" + id
				+ ", createdOn=" + createdOn + ", status=" + status + "]";
	}

	

}
