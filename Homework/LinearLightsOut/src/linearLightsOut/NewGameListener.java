package linearLightsOut;

import java.awt.event.ActionEvent;

/**
 * purpose: listens for user click on "New Game" Button and initiates new game builder method in LinearMain1
 */
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewGameListener implements ActionListener {

	private int nButtons;
	private JFrame frame;
	// private JPanel buttonPanel;

	public NewGameListener(int nButtons, JFrame frame) {
		this.nButtons = nButtons;
		this.frame = frame;
		// this.buttonPanel = buttonPanel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("New Game");
		// this.frame.remove(this.buttonPanel);
		LinearMain1.newGame(this.nButtons, this.frame);
	}
}
