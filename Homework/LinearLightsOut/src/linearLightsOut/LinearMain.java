package linearLightsOut;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Jacob Oblazny. Created Jan 18, 2010.
 */
public class LinearMain {

	JPanel buttonPanel = new JPanel();

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);
		gameLoop(nButtons, false);
	}

	// TODO: you'll want to think about how you want to manage the state of the game

	private static void gameLoop(int nButtons, boolean meetsWinCondition) {
		if (meetsWinCondition) {
			JFrame frame = new JFrame();
			frame.setTitle("You Won!");
		} else {

			JFrame frame = new JFrame();
			frame.setTitle("Linear Lights Out!");

			JPanel buttonPanel = new JPanel();

			Random random = new Random();
			for (int i = 0; i < nButtons; i++) {
				String character = (random.nextBoolean() ? "O" : "X");
				JButton button = new JButton(character);
				buttonPanel.add(button);
				button.addActionListener(new ButtonListener(button, buttonPanel));
			}

			frame.add(buttonPanel, BorderLayout.NORTH);

			// TODO: also you want to add some buttons and stuff

			JPanel adminPanel = new JPanel();

			JButton newGameButton = new JButton("New Game");
			newGameButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("New Game");
					frame.dispose();
					gameLoop(nButtons, false);

				}
			});
			adminPanel.add(newGameButton);

			JButton quitButton = new JButton("Quit");
			quitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Quit");
					System.exit(0);
				}
			});
			adminPanel.add(quitButton);
			frame.add(adminPanel, BorderLayout.SOUTH);

			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}

	public static void changeButton(JButton button, JPanel buttonPanel) {
		if (button.getText().equals("X")) {
			button.setText("O");
		} else {
			button.setText("X");
		}
		checkWinCondition(buttonPanel);
	}

	public static void checkWinCondition(JPanel buttonPanel) {
		ArrayList<String> resultList = new ArrayList<>();
		for (Component button : buttonPanel.getComponents()) {
			JButton checkButton = (JButton) button;
			resultList.add(checkButton.getText());
		}
		System.out.println("CHECKING!");
		if (!resultList.contains("O") || !resultList.contains("X")) {
			System.out.println("WINNER!");
			gameLoop(resultList.size(), true);
		}
	}
}
