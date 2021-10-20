package com.guessnumber.repo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.guessnumber.model.GuessNumber;

@Repository
public class GuessNumberRepositoryImpl implements GuessNumberRepository{
	
	private final String GUESS_CACHE = "GUESS_CACHE";
	private final String key = "GUESS_NUMBER";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, String, GuessNumber> hashOperations;
		
	@Override
	public void setNumber(GuessNumber guessNumber) {
		hashOperations.put(GUESS_CACHE, key, guessNumber);
	}

	@Override
	public GuessNumber getCurrent() {
		return (GuessNumber) hashOperations.get(GUESS_CACHE, key);
	}
	
	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}
}
