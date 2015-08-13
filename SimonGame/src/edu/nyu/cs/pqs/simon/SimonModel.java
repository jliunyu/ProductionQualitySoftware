package edu.nyu.cs.pqs.simon;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * SimonModel class is a class for creating a color sequence and compare the
 * button the user clicked and the button in the sequence the class is also used
 * for register a user and unregister a user besides, it's used for switch user
 * 
 * @author jingliu
 * 
 */
public class SimonModel {
	List<SimonColor> sequence = new LinkedList<SimonColor>();
	int currentGuessSequenceIndex = 0;
	private int currentUserId;
	List<Integer> registeredUserIds = new LinkedList<Integer>();
	private Random random = new Random();
	List<SimonListener> listeners = new LinkedList<SimonListener>();

	/**
	 * call the fireGameStartedEvent() method
	 * 
	 * @param userID
	 */
	public void startGame(int userID) {
		fireGameStartedEvent(userID);
	}

	/**
	 * notify the view that the game started and call the playFirstSequence()
	 * method
	 * 
	 * @param userID
	 */
	public void fireGameStartedEvent(int userID) {
		for (SimonListener simonListener : listeners) {
			simonListener.start(userID);
		}
		playFirstSequence(userID);
	}

	/**
	 * display the first sequence of the game, which includes only one element
	 * 
	 * @param userID
	 */
	private void playFirstSequence(int userID) {
		currentUserId = userID;
		currentGuessSequenceIndex = 0;
		sequence = new LinkedList<SimonColor>();
		SimonColor[] colors = SimonColor.values();
		int nextColorIndex = random.nextInt(colors.length);
		SimonColor newColor = colors[nextColorIndex];
		sequence.add(newColor);
		currentGuessSequenceIndex = 0;
		rotateUser();
		fireDisplaySequenceEvent(currentUserId, sequence);
	}

	/**
	 * judge whether the user click the right button, if the user click the right
	 * button, continue, if not, game over
	 * 
	 * @param userId
	 * @param color
	 */
	public void chooseColor(int userId, SimonColor color) {
		SimonColor currentColor = sequence.get(currentGuessSequenceIndex);

		if (color == currentColor) {
			currentGuessSequenceIndex++;
			if (currentGuessSequenceIndex == sequence.size()) {
				playNextSequence(userId);
			}
		} else {
			fireGameOverEvent(currentColor, userId);
		}
	}

	/**
	 * notify the view that the game is over
	 * 
	 * @param currentColor
	 * @param currentID
	 */
	private void fireGameOverEvent(SimonColor currentColor, int currentID) {
		for (SimonListener simonListener : listeners) {
			simonListener.gameOver(currentColor, currentID);
		}
	}

	/**
	 * add a new color to the last sequence and rotate to another user
	 * 
	 * @param userID
	 */
	private void playNextSequence(int userID) {
		currentUserId = userID;
		SimonColor[] colors = SimonColor.values();
		int nextColorIndex = random.nextInt(colors.length);
		SimonColor newColor = colors[nextColorIndex];
		sequence.add(newColor);
		currentGuessSequenceIndex = 0;
		rotateUser();
		fireDisplaySequenceEvent(currentUserId, sequence);
	}

	/**
	 * notify the new sequence to all the users
	 * 
	 * @param currentUserId2
	 * @param sequence2
	 */
	private void fireDisplaySequenceEvent(int currentUserId2,
			List<SimonColor> sequence2) {
		for (SimonListener listener : listeners) {
			listener.displaySequence(currentUserId2, sequence2);
		}
	}

	/**
	 * rotate the turn to next user
	 */
	private void rotateUser() {
		int currentUserIndex = registeredUserIds.indexOf(currentUserId);
		int nextUserIndex = (currentUserIndex + 1) % registeredUserIds.size();
		currentUserId = registeredUserIds.get(nextUserIndex);
		for (SimonListener listener : listeners) {
			listener.changeButtons(currentUserId);
		}
	}

	/**
	 * register a new user
	 * 
	 * @param userID
	 * @param simonView
	 */
	public void userRegistered(int userID, SimonListener simonView) {
		int i = listeners.indexOf(simonView);
		if (i >= 0) {
		} else {
			registeredUserIds.add(userID);
			listeners.add(simonView);
		}
	}

	/**
	 * UnRegister a user
	 * 
	 * @param simonView
	 */
	public void userUnRegistered(SimonListener simonView) {
		int i = listeners.indexOf(simonView);
		if (i >= 0) {
			listeners.remove(i);
			registeredUserIds.remove(i);
		}
	}
}
