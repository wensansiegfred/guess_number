package com.guessnumber.exceptionhandling;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionRequestHandler {
	
	@ExceptionHandler(value = {GuessNumberRequestException.class})
	public ResponseEntity<Object> handleExceptionRequest(GuessNumberRequestException er) {		
		GuessNumberException guessNumberException = new GuessNumberException(er.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<>(guessNumberException, HttpStatus.BAD_REQUEST);
	}
}
