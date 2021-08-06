package org.tc.timesheet.util;

public class ResponceException extends Exception {
	public ResponceException() {
		super();		
	}	
	public ResponceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}	
	public ResponceException(String message, Throwable cause) {
		super(message, cause);		
	}
	public ResponceException(String message) {
		super(message);	
	}
	public ResponceException(Throwable cause) {
		super(cause);
		
	}
	
}
