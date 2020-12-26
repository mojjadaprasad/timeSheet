package org.tc.timesheet.dto;

import java.util.Date;

import javax.persistence.Column;

import org.tc.timesheet.model.AssignmentModel;

public class TimeSheetDto extends BaseDto {
	
	private AssignmentModel assignment;
	private Date date;
	private int hours;
	private String comments;
	
	
	public Long getId() {
		return super.id;
	}

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public AssignmentModel getAssignment() {
		return assignment;
	}


	public void setAssignment(AssignmentModel assignment) {
		this.assignment = assignment;
	}


	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		// TODO Auto-generated method stub
		return super.createdOn;
	}


	@Override
	public String toString() {
		return "TimeSheetModel [assignment=" + assignment + ", date=" + date + ", hours=" + hours + ", comments="
				+ comments + ", id=" + id + ", createdOn=" + createdOn + "]";
	}
	
}
