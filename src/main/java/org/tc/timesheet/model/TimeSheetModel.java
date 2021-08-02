package org.tc.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "time_sheet_trn_tbl")
public class TimeSheetModel extends BaseEntity {

	
	private AssignmentModel assignment;
	private Date date;
	private int hours;
	private String comments;

	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	public Long getId() {
		return super.id;
	}


	@ManyToOne
	@JoinColumn(name = "ASSIGNMENT_ID")
	public AssignmentModel getAssignment() {
		return assignment;
	}

	public void setAssignment(AssignmentModel assignment) {
		this.assignment = assignment;
	}
	@Column(name = "DATE")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "HOURS")
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Column(name = "COMMENTS")
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
