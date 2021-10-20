package com.guessnumber.model;

public class Message {
	private int guessed_number;
	private int attempt;
	
	public int getGuessed_number() {
		return guessed_number;
	}
	public void setGuessed_number(int guessed_number) {
		this.guessed_number = guessed_number;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	public Message(int guessed_number, int attempt) {
		super();
		this.guessed_number = guessed_number;
		this.attempt = attempt;
	}
}
