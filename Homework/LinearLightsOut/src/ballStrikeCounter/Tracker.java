package ballStrikeCounter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author oblaznjc
 * 
 *         Purpose: Used to track balls and strikes for a baseball game <br>
 *         Restrictions: None <br>
 *         For Example: <br>
 *         new Tracker();
 *
 */
public class Tracker {
	private JLabel label = new JLabel();
	private int numBalls = 0;
	private int numStrikes = 0;

	/**
	 * ensures: updates the text on the label
	 * 
	 * @param numBalls   the number of balls recorded by the GUI for the current
	 *                   batter
	 * @param numStrikes the number of strikes recorded by the GUI for the current
	 *                   batter
	 */
	public void updateLabel(int numBalls, int numStrikes) {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");
	}

	public static void main(String[] args) {
		new Tracker();
	}

	/**
	 * ensures: initializes the tracker's GUI and adds buttons, action listeners
	 * 
	 */
	public Tracker() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);

		// creates Buttons

		JButton ballButton = new JButton("Add Ball");
		JButton strikeButton = new JButton("Add Strike");

		// adds invisible ActionListeners to both buttons
		strikeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++numStrikes;
				if (numStrikes >= 3) {
					numStrikes = 0;
					numBalls = 0;
				}
				updateLabel(numBalls, numStrikes);

			}
		});

		ballButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++numBalls;
				if (numBalls >= 4) {
					numStrikes = 0;
					numBalls = 0;
				}
				updateLabel(numBalls, numStrikes);

			}
		});

		// add buttons to panel
		panel.add(ballButton);
		panel.add(strikeButton);

		// The following line is given to show you how to use the given method:
		updateLabel(numBalls, numStrikes);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
