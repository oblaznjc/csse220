import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * The main which creates the window.
 * 
 * Modify this class as you need.
 * 
 */
public class RockPaperScissorsMain {

	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 420;

	// Used in Part 2
	// Feel free to change to speed things up
	public static final int DELAY = 20;

	// Used in Part 6
	public static final int SPAWN_X = 450;
	public static final int SPAWN_Y = 250;
	public static final int SPAWN_DY = -5;
	public static final int SPAWN_DX = -5;

	public static void main(String[] args) {
		new RockPaperScissorsMain();
	}

	public RockPaperScissorsMain() {

		JFrame frame = new JFrame("Final Question");

		// Hint: Might want to refer back to this below
		RPSComponent component = new RPSComponent();
		component.setPreferredSize(new Dimension(600, 420));
		frame.add(component, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		// should not need to change anything above here

		// Timer

		// 2. Add the advanceListener to the button.
		// button.addActionListener(advanceListener);
		// 3. Add the advanceListener to a Timer
		Timer timer = new Timer(DELAY, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.update();
			}
		});

		// Buttons
		JButton stepButton = new JButton("Step");
		buttonPanel.add(stepButton);

		JButton playButton = new JButton("Play");
		buttonPanel.add(playButton);

		JButton shootButton = new JButton("Shoot Cannon");
		buttonPanel.add(shootButton);

		// TODO add more code here for buttons and listeners, etc
		buttonPanel.add(stepButton);
		buttonPanel.add(playButton);
		buttonPanel.add(shootButton);

		// Listeners

		stepButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.timeStep();
			}
		});

		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()) {
					playButton.setText("Play");
					timer.stop();
				} else {
					timer.start();
					playButton.setText("Pause");
				}

			}
		});

		// Starter Code - For Part 6
		String[] choices = { "Rock", "Paper", "Scissors" };
		final JComboBox<String> spriteSelector = new JComboBox<String>(choices);
		String selectedItem = (String) spriteSelector.getSelectedItem();
		System.out.println(selectedItem);
		// End Starter Code
		buttonPanel.add(spriteSelector);

		// TODO add more code here for buttons and listeners, etc
		shootButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) spriteSelector.getSelectedItem();
				if (selectedItem.equals("Rock")) {
					// Rock1 should start at (20,100), with an x-velocity 0 and y-velocity +5
					Rock rock = new Rock(SPAWN_X, SPAWN_Y, SPAWN_DX, SPAWN_DY);
					component.sprites.add(rock);
				} else if (selectedItem.equals("Paper")) {
					// Paper
					Paper paper = new Paper(SPAWN_X, SPAWN_Y, SPAWN_DX, SPAWN_DY);
					component.sprites.add(paper);
				} else if (selectedItem.equals("Scissors")) {
					// Scissors
					Scissors scissors = new Scissors(SPAWN_X, SPAWN_Y, SPAWN_DX, SPAWN_DY);
					component.sprites.add(scissors);
				}
			}
		});
		// should not need to change anything below here
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
