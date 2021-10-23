package com.guessnumber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.incu6us.redis.mock.EnableRedisMockTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.guessnumber.model.GuessNumber;
import com.guessnumber.model.UserGuessMessageAttempt;
import com.guessnumber.model.UserGuessMessageSuccess;
import com.guessnumber.model.UserInput;
import com.guessnumber.repo.GuessNumberRepository;
import com.guessnumber.service.GuessNumberService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@EnableRedisMockTemplate
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GuessNumberApplication.class)
@WebAppConfiguration
public class GuessNumberTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private GuessNumberService guessNumberServiceMock;
	
	@Autowired
	GuessNumberRepository guessNumberRepository;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGuess_start_200() throws Exception {
		UserInput userInput = new UserInput();
		userInput.setAction("start");
		UserGuessMessageAttempt attempt = new UserGuessMessageAttempt(1, 1);		
		
		when(guessNumberServiceMock.startGuess()).thenReturn(attempt);
		
		MvcResult mvc = mockMvc.perform(post("/api/guess_number")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content("{ \"action\": \"start\"}"))
			   .andReturn();
		assertEquals(200, mvc.getResponse().getStatus());
	}
	
	@Test
	public void testStart_guess_number() throws Exception {
		UserInput userInput = new UserInput();
		userInput.setAction("start");
		UserGuessMessageAttempt attempt = new UserGuessMessageAttempt(1, 1);
		
		when(guessNumberServiceMock.startGuess()).thenReturn(attempt);
		
		MvcResult mvcResult = mockMvc.perform(post("/api/guess_number")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(mapToJson(userInput)))
			   .andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		
		String content = mvcResult.getResponse().getContentAsString();
		
		UserGuessMessageAttempt attemptMessage = attemptMap(content);
		
		assertTrue(attemptMessage.getAttempt() > 0);
	}
	
	@Test
	public void testGuess_error_throw() throws Exception {
		UserInput userInput = new UserInput();
		userInput.setAction("=");
		GuessNumber guessNumber = new GuessNumber();
		guessNumber.setAttempt(2);
		guessNumber.setCurrentGuessNumber(5);
		
		when(guessNumberServiceMock.gotItSuccess(guessNumber)).thenReturn(null);
		
		MvcResult mvcResult = mockMvc.perform(post("/api/guess_number")
				   .contentType(MediaType.APPLICATION_JSON)
				   .content(mapToJson(userInput)))
				   .andReturn();
		
		assertEquals(400, mvcResult.getResponse().getStatus());
		
		String content = mvcResult.getResponse().getContentAsString();
		
		UserGuessMessageSuccess success = successMap(content);
		
		assertTrue(success.getMessage().equals("Havent guess a number yet, please select Start."));
		
		assertTrue(success.getAttempt() == 0);
	}
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	
	protected UserGuessMessageAttempt attemptMap(String json) {		
		Gson gson = new GsonBuilder().create();
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(json);
		return gson.fromJson(object, UserGuessMessageAttempt.class);
   }
	
	protected UserGuessMessageSuccess successMap(String json) {		
		Gson gson = new GsonBuilder().create();
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(json);
		return gson.fromJson(object, UserGuessMessageSuccess.class);
   }
}
