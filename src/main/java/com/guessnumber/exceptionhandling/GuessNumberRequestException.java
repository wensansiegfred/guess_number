package com.guessnumber.exceptionhandling;

public class GuessNumberRequestException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GuessNumberRequestException(String message) {
		super(message);
	}
	
	public GuessNumberRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
