package com.guessnumber.service;
import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.UserGuessMessageAttempt;
import com.guessnumber.model.UserGuessMessageSuccess;
import com.guessnumber.repo.GuessNumberRepository;

public class ProcessNumber {
	private final int initMin = 1;
	private final int initMax = 100;	
	
	protected UserGuessMessageAttempt start(GuessNumberRepository guessNumberRepository) {		
		int num = getRandom(initMin, initMax);
		GuessNumber guessNumber = new GuessNumber(num, initMax, initMin, 1);
		guessNumberRepository.setNumber(guessNumber);
		
		return new UserGuessMessageAttempt(num, 1);
	}
	
	protected UserGuessMessageAttempt tryLower(GuessNumber guessNumber, GuessNumberRepository guessNumberRepository) {
		int num = getMidpoint(guessNumber.getMinNumber(), guessNumber.getCurrentGuessNumber() - 1);
		guessNumberRepository.setNumber(new GuessNumber(num, guessNumber.getCurrentGuessNumber() - 1, guessNumber.getMinNumber(), guessNumber.getAttempt() + 1));
		return new UserGuessMessageAttempt(num, guessNumber.getAttempt() + 1);
	}
	
	protected UserGuessMessageAttempt tryHigher(GuessNumber guessNumber, GuessNumberRepository guessNumberRepository) {
		int num = getMidpoint(guessNumber.getCurrentGuessNumber() + 1, guessNumber.getMaxNumber());
		guessNumberRepository.setNumber(new GuessNumber(num, guessNumber.getMaxNumber(), guessNumber.getCurrentGuessNumber() + 1, guessNumber.getAttempt() + 1));		
		
		return new UserGuessMessageAttempt(num, guessNumber.getAttempt() + 1);
	}
	
	protected UserGuessMessageSuccess gotIt(GuessNumber guessNumber, GuessNumberRepository guessNumberRepository) {
		guessNumberRepository.delete();
		return new UserGuessMessageSuccess("Number is predicted properly! Your selected number is " + guessNumber.getCurrentGuessNumber(), guessNumber.getAttempt());
	}
	
	private int getMidpoint(int min, int max) {
		return Math.round((min+max)/2);
	}
	
	private int getRandom(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
