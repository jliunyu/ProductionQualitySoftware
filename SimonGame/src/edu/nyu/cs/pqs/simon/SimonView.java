package edu.nyu.cs.pqs.simon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * SimonView class implements SimonListener interface. The class is an observer
 * in the observer pattern. It's used for display sequence created in the
 * SimonModel class. It's also used for user to click button for choose colors
 * and start the game.
 * 
 * @author jingliu
 * 
 */
public class SimonView implements SimonListener {
	final SimonModel simonModel;

	private final static int DELAY_TIME_PRESS = 500;
	private final static int DELAY_TIME_SHOW = 500;
	private final static int DELAY_TIME_GAP = 500;

	private int ID = -1;

	private JButton redButton = new JButton();
	private JButton blueButton = new JButton();
	private JButton greenButton = new JButton();
	private JButton yellowButton = new JButton();

	private JButton startButton = new JButton("start");
	private JButton registerButton = new JButton("register");

	private JLabel statusLabel = new JLabel("status");
	private JTextArea textArea = new JTextArea();
	private JFrame frame = new JFrame("Simon");

	JButton[] buttonSets = new JButton[4];

	/**
	 * Create for color buttons and put them in the colorPanel Create two control
	 * buttons and put them in the controlPanel Call the startGame() method in the
	 * SimonModel class if the user click the "start" button Call the register()
	 * mothod if the user click the "register" button buttons in the
	 * 
	 * @param userID
	 * @param simonModel
	 */
	public SimonView(int userID, final SimonModel simonModel) {
		final int userId = userID;

		this.simonModel = simonModel;
		this.ID = userId;

		JPanel colorPanel = new JPanel();
		JPanel controlPanel = new JPanel();

		colorPanel.setLayout(new GridLayout(2, 2));
		controlPanel.setLayout(new GridLayout(1, 2));

		/**
		 * if the user click the red button, the red button will flash
		 */
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPressed(userId, 0);
			}
		});

		/**
		 * if the user click the blue button, the blue button will flash
		 */
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPressed(userId, 1);
			}
		});

		/**
		 * if the user click the green button, the green button will flash
		 */
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPressed(userId, 2);
			}
		});

		/**
		 * if the user click the yellow button, the yellow button will flash
		 */
		yellowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPressed(userId, 3);
			}

		});

		redButton.setOpaque(true);
		blueButton.setOpaque(true);
		greenButton.setOpaque(true);
		yellowButton.setOpaque(true);

		redButton.setBackground(Color.RED);
		blueButton.setBackground(Color.BLUE);
		greenButton.setBackground(Color.GREEN);
		yellowButton.setBackground(Color.YELLOW);

		colorPanel.add(redButton);
		colorPanel.add(blueButton);
		colorPanel.add(greenButton);
		colorPanel.add(yellowButton);

		controlPanel.add(startButton);
		controlPanel.add(registerButton);

		Container frameContainer = frame.getContentPane();

		frameContainer.setLayout(new BorderLayout());
		frameContainer.add(colorPanel, BorderLayout.CENTER);
		frameContainer.add(statusLabel, BorderLayout.SOUTH);
		frameContainer.add(controlPanel, BorderLayout.NORTH);

		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simonModel.startGame(userId);
			}
		});

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});

	}

	/**
	 * Call the userRegistered() method in the SimonModel class
	 */
	private void register() {
		simonModel.userRegistered(ID, this);
	}

	/**
	 * when the user click the ith button, the button will flash according to its
	 * color
	 * 
	 * @param userID
	 * @param i
	 */
	private void buttonPressed(int userID, int i) {

		final int userid = userID;
		final SimonColor color = SimonColor.values()[i];

		Timer timer = new Timer(DELAY_TIME_PRESS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				redButton.setBorderPainted(true);
				blueButton.setBorderPainted(true);
				greenButton.setBorderPainted(true);
				yellowButton.setBorderPainted(true);
			}
		});

		Timer timer1 = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorChosen(userid, color);
			}
		});

		switch (i) {
		case 0:
			redButton.setBorderPainted(false);
			timer.setRepeats(false);
			timer.start();
			timer1.setRepeats(false);
			timer1.start();
			break;

		case 1:
			blueButton.setBorderPainted(false);
			timer.setRepeats(false);
			timer.start();
			timer1.setRepeats(false);
			timer1.start();
			break;

		case 2:
			greenButton.setBorderPainted(false);
			timer.setRepeats(false);
			timer.start();
			timer1.setRepeats(false);
			timer1.start();
			break;

		case 3:
			yellowButton.setBorderPainted(false);
			timer.setRepeats(false);
			timer.start();
			timer1.setRepeats(false);
			timer1.start();
			break;
		}
	}

	/**
	 * set the text of the statusLabel to "status"
	 * 
	 * @param userId
	 */
	public void start(int userId) {
		statusLabel.setText("status");
	}

	/**
	 * call the displaySequenceHelper() mothod
	 * 
	 * @param userId
	 * @param colors
	 */
	public void displaySequence(int userId, List<SimonColor> colors) {
		displaySequenceHelper(colors, 0);
	}

	/**
	 * display the SimonColor sequence
	 * 
	 * @param sequences
	 * @param index
	 */
	private void displaySequenceHelper(List<SimonColor> sequences, int index) {
		buttonSets[0] = redButton;
		buttonSets[1] = blueButton;
		buttonSets[2] = greenButton;
		buttonSets[3] = yellowButton;

		if (index >= sequences.size()) {
			return;
		}

		final List<SimonColor> seq = sequences;
		final int i = index + 1;
		int currColorIndex = sequences.get(index).ordinal();

		final JButton currentButton = buttonSets[currColorIndex];
		currentButton.setBorderPainted(false);

		Timer timer = new Timer(DELAY_TIME_SHOW, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentButton.setBorderPainted(true);

				Timer gapTimer = new Timer(DELAY_TIME_GAP, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						displaySequenceHelper(seq, i);
					}
				});

				gapTimer.setRepeats(false);
				gapTimer.start();
			}
		});

		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * call the chooseColor() mothod in the simonModel class
	 * 
	 * @param userId
	 * @param color
	 */
	public void colorChosen(int userId, SimonColor color) {
		simonModel.chooseColor(userId, color);
	}

	/**
	 * display the result of the game
	 * 
	 * @param correctColor
	 * @param currentID
	 */
	public void gameOver(SimonColor correctColor, int currentID) {
		if (this.ID == currentID) {
			statusLabel.setText("Game Over and you lost");
		} else {
			statusLabel.setText("Game Over and you win");
		}
	}

	/**
	 * set whether the button is usable or not
	 * 
	 * @param currentUserId
	 */
	public void changeButtons(int currentUserId) {
		if (this.ID != currentUserId) {
			frame.setEnabled(false);
			statusLabel.setText("status");
		} else {
			frame.setEnabled(true);
			statusLabel.setText("It's your turn");
		}
	}
}
