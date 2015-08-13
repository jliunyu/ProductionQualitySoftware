package edu.nyu.cs.pqs.guessnum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumView implements GuessNumListener {
	private GuessNumModel guessNumModel;
	private JButton button = new JButton("Guess");
	private JTextField field = new JTextField();
	private JTextArea textArea = new JTextArea();
	
	public GuessNumView(GuessNumModel guessNumModel) {
		this.guessNumModel = guessNumModel;
		
		guessNumModel.addGuessNumListener(this);
		
		JFrame frame = new JFrame("GuessNum");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(field, BorderLayout.CENTER);
		bottomPanel.add(button, BorderLayout.EAST);
		
		panel.add(bottomPanel, BorderLayout.SOUTH);
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		frame.getContentPane().add(panel);
		
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPressed();
			}
		});
		
	}
	
	private void buttonPressed() {
		int guess = Integer.parseInt(field.getText());
		guessNumModel.guess(guess);
	}
	
	@Override
	public void gameStarted() {
		textArea.append("Game started.\n");
	}

	@Override
	public void guessHigh(int guess) {
		textArea.append(guess + " too high, try again.\n");
	}

	@Override
	public void guessLow(int guess) {
		textArea.append(guess + " low, try again.\n");
	}

	@Override
	public void guessCorrect(int guess) {
		textArea.append(guess + " is right! Good work!!!\n");
	}
}
