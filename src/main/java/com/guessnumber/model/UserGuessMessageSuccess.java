package com.guessnumber.model;

public class UserGuessMessageSuccess {
	private String message;
	private int attempt;
	
	public UserGuessMessageSuccess() {}
	public UserGuessMessageSuccess(String message, int attempt) {
		super();
		this.message = message;
		this.attempt = attempt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAttempt() {
		return attempt;
	}
	@Override
	public String toString() {
		return "UserGuessMessageSuccess [message=" + message + ", attempt=" + attempt + "]";
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	
}
