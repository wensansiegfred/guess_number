package com.guessnumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.UserGuessMessageAttempt;
import com.guessnumber.model.UserGuessMessageSuccess;
import com.guessnumber.repo.GuessNumberRepository;

@Service
public class GuessNumberService extends ProcessNumber {	
	
	@Autowired
	GuessNumberRepository guessNumberRepository;
	
	public UserGuessMessageAttempt startGuess() {
		return start(guessNumberRepository);
	}
	
	public UserGuessMessageAttempt tryLowerGuess(GuessNumber guessNumber) {
		return tryLower(guessNumber, guessNumberRepository);
	}
	
	public UserGuessMessageAttempt tryHigherGuess(GuessNumber guessNumber) {
		return tryHigher(guessNumber, guessNumberRepository);
	}
	
	public UserGuessMessageSuccess gotItSuccess(GuessNumber guessNumber) {
		return gotIt(guessNumber, guessNumberRepository);
	}
}
