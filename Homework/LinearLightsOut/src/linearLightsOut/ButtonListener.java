package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonListener implements ActionListener {
	private ArrayList<JButton> buttonList;
	private int currentButtonIndex;
	private JFrame frame;

	public ButtonListener(JButton button, ArrayList<JButton> buttonList, JFrame frame) {
		this.buttonList = buttonList;
		this.currentButtonIndex = buttonList.size() - 1;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.currentButtonIndex);
		LinearMain1.chooseButtons(this.currentButtonIndex, this.buttonList, this.frame);
	}
}
