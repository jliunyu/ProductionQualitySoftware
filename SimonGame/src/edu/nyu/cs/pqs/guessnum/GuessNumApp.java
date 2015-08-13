package edu.nyu.cs.pqs.guessnum;

public class GuessNumApp {

	public static void main(String[] args) {
		GuessNumModel model = new GuessNumModel();
		new GuessNumView(model);
		new GuessNumView(model);
		new GuessNumView(model);
		new GuessNumView(model);
		new GuessNumView(model);
		new GuessNumView(model);
		model.startGame();
	}

}
