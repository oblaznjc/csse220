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
import javax.swing.JRootPane;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Jacob Oblazny. Created Jan 18, 2010.
 */
public class LinearMain1 {

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);

		// Instantiates frame and sets title
		JFrame frame = new JFrame();

		newGame(nButtons, frame);
	}

	// TODO: you'll want to think about how you want to manage the state of the game
	/**
	 * ensures: builds the administrative buttons that don't need to be created multiple times
	 * 
	 * @param nButtons
	 * @param frame
	 * @return
	 */
	static JFrame adminSetup(int nButtons, JFrame frame) {
		// dispose of current frame restart with new frame
		frame.dispose();
		JFrame newFrame = new JFrame();
		newFrame.setTitle("Linear Lights Out!");

		// Instantiates panels for GUI
		JPanel adminPanel = new JPanel();
		// JPanel buttonPanel = new JPanel();

		// instantiates administrative buttons
		JButton newGameButton = new JButton("New Game");
		JButton quitButton = new JButton("Quit");

		// adds ActionListeners to administrative buttons
		newGameButton.addActionListener(new NewGameListener(nButtons, newFrame));
		quitButton.addActionListener(new QuitListener());

		// add administrative buttons to administrative panel
		adminPanel.add(newGameButton);
		adminPanel.add(quitButton);

		// add panels to frame
		// frame.add(buttonPanel, BorderLayout.NORTH);
		newFrame.add(adminPanel, BorderLayout.SOUTH);

		return newFrame;
	}

	/**
	 * ensures: that a new game can be created whenever a player presses the new
	 * game button, without returning to input screen
	 * 
	 * @param nButtons
	 * @param frame
	 */
	static void newGame(int nButtons, JFrame frame) {
		frame = adminSetup(nButtons, frame);

		// add button panel
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel, BorderLayout.NORTH);

		// Creates set of buttons and adds to buttonPanel, buttonList
		ArrayList<JButton> buttonList = new ArrayList<>();

		Random random = new Random();
		for (int i = 0; i < nButtons; i++) {
			String character = (random.nextBoolean() ? "O" : "X");
			JButton button = new JButton(character);
			buttonPanel.add(button);
			buttonList.add(button);
			button.addActionListener(new ButtonListener(button, buttonList, frame));
		}

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * ensures: chooses which buttons must be flipped "X to O" v.v. based on user
	 * input
	 * 
	 * @param index
	 * @param buttonList
	 * @param frame
	 */
	public static void chooseButtons(int index, ArrayList<JButton> buttonList, JFrame frame) {
		changeButton(buttonList.get(index));
		if (index == 0) {
			changeButton(buttonList.get(index + 1));
		} else if (index == buttonList.size() - 1) {
			changeButton(buttonList.get(index - 1));
		} else {
			changeButton(buttonList.get(index + 1));
			changeButton(buttonList.get(index - 1));
		}
		checkWinCondition(buttonList, frame);
	}

	/**
	 * ensures: changes the button string of a single button to opposite "X" or "O"
	 * 
	 * @param button
	 */
	public static void changeButton(JButton button) {
		if (button.getText().equals("X")) {
			button.setText("O");
		} else {
			button.setText("X");
		}
	}

	/**
	 * ensures: checks if all buttons are the same string, and returns a winning
	 * title
	 * 
	 * @param buttonList list of all game buttons in button panel
	 * @param frame
	 */
	public static void checkWinCondition(ArrayList<JButton> buttonList, JFrame frame) {
		ArrayList<String> resultList = new ArrayList<>();
		for (JButton button : buttonList) {
			resultList.add(button.getText());
		}
		if (!resultList.contains("O") || !resultList.contains("X")) {
			frame.setTitle("Winner! Winner! Chicken Dinner!");
		}
	}
}
