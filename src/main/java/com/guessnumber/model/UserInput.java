package com.guessnumber.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserInput implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String action;
	private int attempt;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	@Override
	public String toString() {
		return "UserInput [action=" + action + ", attempt=" + attempt + "]";
	}
}
