package com.guessnumber.repo;

import com.guessnumber.model.GuessNumber;

public interface GuessNumberRepository {
	void setNumber(GuessNumber guessNumber);
	GuessNumber getCurrent();
}
