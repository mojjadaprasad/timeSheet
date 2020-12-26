package org.tc.timesheet.dto;

import java.util.Date;

public abstract class BaseDto {

	protected Long id;
	protected Date createdOn;
	
	abstract Long getId();
	
	public void setId(Long id) {
		this.id = id;
	}
	abstract Date getCreatedOn() ;
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
