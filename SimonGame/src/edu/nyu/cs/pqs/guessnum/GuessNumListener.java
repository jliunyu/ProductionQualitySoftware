package edu.nyu.cs.pqs.guessnum;

public interface GuessNumListener {
	void gameStarted();
	void guessHigh(int guess);
	void guessLow(int guess);
	void guessCorrect(int guess);
}
