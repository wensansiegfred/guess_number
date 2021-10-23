package com.guessnumber.exceptionhandling;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class GuessNumberException {
	
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	private final String message;	
	
	public GuessNumberException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
		super();
		this.message = message;		
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
}
