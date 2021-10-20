package com.guessnumber.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.UserInput;
import com.guessnumber.repo.GuessNumberRepository;

@Service
public class GuessNumberService extends ProcessNumber {
	private Map<String, Object> message;
	
	private final GuessNumberRepository guessNumberRepository;	
	
	public GuessNumberService(GuessNumberRepository guessNumberRepository) {
		this.guessNumberRepository = guessNumberRepository;
	}
	
	public Object guessIt(UserInput userInput) {
		GuessNumber guessNumber = guessNumberRepository.getCurrent();
		System.out.println(userInput);
		System.out.println(guessNumber);
		
		switch(userInput.getAction()) {
			case "start":
				message = start(guessNumberRepository);
			break;
			case "<":
				message = tryLower(guessNumber, guessNumberRepository);
			break;
			case ">":
				message = tryHigher(guessNumber, guessNumberRepository);
			break;
			case "=":
				return gotIt(guessNumber);
			default:
				message = null;
		}
		
		return message;
	}
}
