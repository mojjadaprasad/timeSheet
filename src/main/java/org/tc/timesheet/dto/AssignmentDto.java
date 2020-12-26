package org.tc.timesheet.dto;

import java.util.Date;

import org.tc.timesheet.model.EmployeeModel;
import org.tc.timesheet.model.ManagerModel;

public class AssignmentDto extends BaseDto{

	private EmployeeModel employee;
	private ManagerModel manager;
	private Date fromDate;
	private String status;
	private Date toDate;
	private String task;
	private String projectName;
	private String weekEnds;
	public String getWeekEnds() {
		return weekEnds;
	}
	public void setWeekEnds(String weekEnds) {
		this.weekEnds = weekEnds;
	}
	public Long getId() {
		return super.id;
	}
	
	public EmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}
	public ManagerModel getManager() {
		return manager;
	}
	public void setManager(ManagerModel manager) {
		this.manager = manager;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
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
		return "AssignmentModel [employee=" + employee + ", manager=" + manager + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", task=" + task + ", projectName=" + projectName + ", weekEnds=" + weekEnds + ", id=" + id
				+ ", createdOn=" + createdOn + ", status=" + status + "]";
	}




	

}
