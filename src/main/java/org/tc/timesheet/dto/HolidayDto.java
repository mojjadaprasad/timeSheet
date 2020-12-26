package org.tc.timesheet.dto;

import java.util.Date;

public class HolidayDto extends BaseDto {

	private Date date;
	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "HolidayDto [date=" + date + ", description=" + description + "]";
	}
}
