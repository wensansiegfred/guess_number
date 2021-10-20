package com.guessnumber.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guessnumber.model.UserInput;
import com.guessnumber.service.GuessNumberService;

@RestController
@RequestMapping("/api/guess_number")
public class GuessNumberController {
	
	@Autowired
	private GuessNumberService guessNumberService;
		
	@SuppressWarnings("unchecked")
	@PostMapping
	public Map<String, Object> startGuessing(@RequestBody final UserInput userInput) {		
		return (Map<String, Object>) guessNumberService.guessIt(userInput);
	}
}
