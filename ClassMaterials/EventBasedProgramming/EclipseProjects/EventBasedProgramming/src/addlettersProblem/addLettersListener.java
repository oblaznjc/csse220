package addlettersProblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class addLettersListener implements ActionListener {
	JLabel label;
	String letter;
	
	public addLettersListener(JLabel label, String letter) {
		this.label = label;
		this.letter = letter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		
		this.label.setText(this.label.getText() + this.letter);
	}

}
