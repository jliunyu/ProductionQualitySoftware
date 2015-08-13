package edu.nyu.cs.pqs.simon;

/**
 * This is an interface class, implemented by SimonView, the class 
 * includes methods of displaySequence(), colorChosen(), gameOver(), changeButtons()
 */
import java.util.List;

public interface SimonListener {
	void start(int userId);

	void displaySequence(int userId, List<SimonColor> colors);

	void colorChosen(int userId, SimonColor color);

	void gameOver(SimonColor correctColor, int userID);

	void changeButtons(int currentUserId);
}
