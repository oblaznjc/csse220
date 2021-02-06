package slides;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyListener implements ActionListener {

	private JFrame frame;

	public MyListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Too Hot!");
		frame.setTitle("YAYAYAYA");
	}

}
