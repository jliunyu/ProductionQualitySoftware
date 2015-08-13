package edu.nyu.cs.pqs.simon;

/**
 * This class is for creating object for SimonModel and SimonView. It's used for
 * start the game
 * 
 * @author jingliu
 * 
 */
public class SimonApp {
	public static void main(String[] args) {
		SimonModel model = new SimonModel();

		int userID = 0;
		SimonListener simonView = new SimonView(userID, model);
		simonView.start(userID);

		userID++;
		SimonListener simonView1 = new SimonView(userID, model);
		simonView1.start(userID);

		userID++;
		SimonListener simonView2 = new SimonView(userID, model);
		simonView2.start(userID);

	}
}
