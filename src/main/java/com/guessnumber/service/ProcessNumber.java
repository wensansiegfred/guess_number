package com.guessnumber.service;

import java.util.HashMap;
import java.util.Map;

import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.Message;
import com.guessnumber.repo.GuessNumberRepository;

public class ProcessNumber {
	private final int initMin = 1;
	private final int initMax = 100;
	
	protected Message start(GuessNumberRepository guessNumberRepository) {
		int num = getMidpoint(initMin, initMax);		
		GuessNumber guessNumber = new GuessNumber(num, initMax, initMin, 1);
		guessNumberRepository.setNumber(guessNumber);
		
		return new Message(num, 1);
	}
	
	protected Message tryLower(GuessNumber guessNumber, GuessNumberRepository guessNumberRepository) {
		int num = getMidpoint(guessNumber.getMinNumber(), guessNumber.getCurrentGuessNumber() - 1);
		guessNumberRepository.setNumber(new GuessNumber(num, guessNumber.getCurrentGuessNumber() - 1, guessNumber.getMinNumber(), guessNumber.getAttempt() + 1));
		
		return new Message(num, guessNumber.getAttempt() + 1);
	}
	
	protected Message tryHigher(GuessNumber guessNumber, GuessNumberRepository guessNumberRepository) {
		int num = getMidpoint(guessNumber.getCurrentGuessNumber() + 1, guessNumber.getMaxNumber());
		guessNumberRepository.setNumber(new GuessNumber(num, guessNumber.getMaxNumber(), guessNumber.getCurrentGuessNumber() + 1, guessNumber.getAttempt() + 1));
		return new Message(num, guessNumber.getAttempt() + 1);
	}
	
	protected Map<String, Object> gotIt(GuessNumber guessNumber) {
		Map<String, Object> gotIt = new HashMap<String, Object>();
		gotIt.put("message", "Number is predicted properly! Your selected number is " + guessNumber.getCurrentGuessNumber());
		gotIt.put("attempt", (Integer) guessNumber.getAttempt());
		return gotIt;
	}
	
	private int getMidpoint(int min, int max) {
		return Math.round((min+max)/2);
	}
}
