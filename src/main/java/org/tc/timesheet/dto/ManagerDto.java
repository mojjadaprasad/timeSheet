package org.tc.timesheet.dto;

public class ManagerDto extends BaseDto {

	private String name;
	private String mailId;
	private String status;

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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ManagerDto [name=" + name + ", mailId=" + mailId + ", status=" + status + ", id=" + id + ", createdOn="
				+ createdOn + "]";
	}
}
