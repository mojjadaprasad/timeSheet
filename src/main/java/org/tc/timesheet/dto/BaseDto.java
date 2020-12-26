package org.tc.timesheet.dto;

import java.util.Date;

public abstract class BaseDto {

	protected Long id;
	protected Date createdOn;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
