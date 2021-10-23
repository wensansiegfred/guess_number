package com.guessnumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guessnumber.exceptionhandling.GuessNumberRequestException;
import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.UserInput;
import com.guessnumber.repo.GuessNumberRepository;
import com.guessnumber.service.GuessNumberService;

@RestController
@RequestMapping("/api")
public class GuessNumberController {
	
	@Autowired
	private GuessNumberService guessNumberService;
	
	@Autowired
	private GuessNumberRepository guessNumberRepository;	
	
	@PostMapping("/guess_number")
	public ResponseEntity<Object> startGuessing(@RequestBody final UserInput userInput) throws Exception {
		GuessNumber guessNumber = guessNumberRepository.getCurrent();		
		String action = userInput.getAction();
		
		if (action.equals("start")) {
			return ResponseEntity.ok(guessNumberService.startGuess());
		} else if (action.equals("<")) {
			if (guessNumber == null)
				throw new GuessNumberRequestException("Havent guess a number yet, please select Start.");
			else
				return ResponseEntity.ok(guessNumberService.tryLowerGuess(guessNumber));
		} else if (action.equals(">")) {
			if (guessNumber == null)
				throw new GuessNumberRequestException("Havent guess a number yet, please select Start.");
			else
				return ResponseEntity.ok(guessNumberService.tryHigherGuess(guessNumber));
		} else if (action.equals("=")) {
			if (guessNumber == null)
				throw new GuessNumberRequestException("Havent guess a number yet, please select Start.");
			else
				return ResponseEntity.ok(guessNumberService.gotItSuccess(guessNumber));
		} else {		
			throw new GuessNumberRequestException("Invalid Action value.");
		}
		
	}
}
