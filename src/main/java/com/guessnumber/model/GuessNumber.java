package com.guessnumber.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class GuessNumber implements Serializable  {	
	
	private static final long serialVersionUID = 1L;
	
	private int currentGuessNumber;	
	private int maxNumber;
	private int minNumber;
	private int attempt;
	
	public GuessNumber() {}
	
	public GuessNumber(int currentGuessNumber, int maxNumber, int minNumber, int attempt) {
		super();
		this.currentGuessNumber = currentGuessNumber;		
		this.maxNumber = maxNumber;
		this.minNumber = minNumber;
		this.attempt = attempt;
	}
	public int getCurrentGuessNumber() {
		return currentGuessNumber;
	}
	public void setCurrentGuessNumber(int currentGuessNumber) {
		this.currentGuessNumber = currentGuessNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getMinNumber() {
		return minNumber;
	}
	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	@Override
	public String toString() {
		return "GuessNumber [currentGuessNumber=" + currentGuessNumber + ", maxNumber=" + maxNumber + ", minNumber=" + minNumber + ", attempt=" + attempt + "]";
	}
}
