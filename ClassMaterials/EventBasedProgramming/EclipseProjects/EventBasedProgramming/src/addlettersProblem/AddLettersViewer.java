package addlettersProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

public class AddLettersViewer {

	public static void main(String[] args) {
		new AddLettersViewer();
	}
	
	public AddLettersViewer() {	
		JFrame frame = new JFrame();
		
		
		// put your new JButtons, JLabels, etc here
		
		JButton addA = new JButton("Add A");
		JButton addB = new JButton("Add B");
		JButton addC = new JButton("Add C");
		
		JPanel panel = new JPanel();
		
		panel.add(addA);
		panel.add(addB);
		panel.add(addC);

		frame.add(panel, BorderLayout.SOUTH);
		
		JLabel label = new JLabel(">>>");
		
		addA.addActionListener(new addLettersListener(label, "A"));
		addB.addActionListener(new addLettersListener(label, "B"));
		addC.addActionListener(new addLettersListener(label, "C"));
		
		frame.add(label, BorderLayout.NORTH);
		
		
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
