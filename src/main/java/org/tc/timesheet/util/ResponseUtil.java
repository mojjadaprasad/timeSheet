package org.tc.timesheet.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
	
	private ResponseUtil() {}

	public static <T> ResponseEntity<T> error(T data) {
		return new ResponseEntity<T>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static <T> ResponseEntity<T> error(T data, HttpHeaders headers) {
		return new ResponseEntity<T>(data, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static <T> ResponseEntity<T> success(T data) {
		return new ResponseEntity<T>(data, HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<T> created(T data) {
		return new ResponseEntity<T>(data, HttpStatus.CREATED);
	}
}
