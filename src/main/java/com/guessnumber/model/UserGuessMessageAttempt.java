package com.guessnumber.model;

public class UserGuessMessageAttempt {
	private int guess_number;
	private int attempt;
	
	public UserGuessMessageAttempt() {}
	public UserGuessMessageAttempt(int guess_number, int attempt) {
		super();
		this.guess_number = guess_number;
		this.attempt = attempt;
	}
	public int getGuess_number() {
		return guess_number;
	}
	public void setGuess_number(int guess_number) {
		this.guess_number = guess_number;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}	
	
}
