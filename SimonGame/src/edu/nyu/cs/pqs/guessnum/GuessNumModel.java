package edu.nyu.cs.pqs.guessnum;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GuessNumModel {
	private int num;
	private List<GuessNumListener> listeners = new LinkedList<GuessNumListener>();
	
	public GuessNumModel() {
		num = new Random().nextInt(100);
	}

	public void startGame() {
		fireGameStartedEvent();
	}

	public void guess(int guess) {
		if (guess == num) {
			fireGuessCorrectEvent(guess);
		} else if (guess < num) {
			fireGuessLowEvent(guess);
		} else {
			fireGuessHighEvent(guess);
		}
	}
	
	private void fireGameStartedEvent() {
		for (GuessNumListener listener : listeners) {
			listener.gameStarted();
		}
	}
	private void fireGuessHighEvent(int guess) {
		for (GuessNumListener listener : listeners) {
			listener.guessHigh(guess);
		}		
	}
	private void fireGuessLowEvent(int guess) {
		for (GuessNumListener listener : listeners) {
			listener.guessLow(guess);
		}		
	}
	private void fireGuessCorrectEvent(int guess) {
		for (GuessNumListener listener : listeners) {
			listener.guessCorrect(guess);
		}
	}
	public void addGuessNumListener(GuessNumListener guessNumListener) {
		listeners.add(guessNumListener);
	}
	
}
















