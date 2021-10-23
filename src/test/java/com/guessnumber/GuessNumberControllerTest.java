package com.guessnumber;
/*
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.guessnumber.controller.GuessNumberController;
import com.guessnumber.model.UserInput;
import com.guessnumber.service.GuessNumberService;

@ExtendWith(MockitoExtension.class)
public class GuessNumberControllerTest {
	
	@InjectMocks
	GuessNumberController guessNumberController;
	
	@Mock
	GuessNumberService guessNumberService;	
	
	@Test
	public void testGuessNumberStart() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        UserInput userInput = new UserInput();
        userInput.setAction("start");
        
        ResponseEntity<Object> responseEntity = guessNumberController.startGuessing(userInput);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
}
*/