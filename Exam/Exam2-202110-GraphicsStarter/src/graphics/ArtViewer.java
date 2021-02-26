package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class starts the program which allows a user to draw a picture with
 * customizable colors and brush strokes.
 * 
 * 
 * @author oblaznjc
 *
 */
public class ArtViewer {

	// TODO: you may want to add instance variables here or somewhere else

	public static void main(String[] args) {
		new ArtViewer();
	}

	// instance context
	public ArtViewer() {
		JFrame frame = new JFrame();
		int frameWidth = 800;
		int frameHeight = 550;

		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Graphics Question");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 200);

		ArtComponent component = new ArtComponent();
		frame.add(component);

		// Provided code - JPanel background colored to easily separate
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.GRAY);

		// TODO Part 1 - Allow User to draw on screen:
		// 1.1 Complete the BrushStroke class.
		// Suggestion: add a single BrushStroke inside of
		// ArtComponent instead of the drawn line
		// (to test that your BrushStroke class is working).
		// 1.2 Add listeners to react to events created by the mouse
		// Hint: you will want both a MouseListener AND MouseMotionListener
		// We have provided a MouseMotionListener below so you can see how it works
		// Run the start program and try dragging (moving with the mouse down)
		// or moving the mouse
		component.addMouseMotionListener(new MouseMotionListener() {
			private int x1;
			private int y1;
			private boolean drawingStatus;

			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("Mouse moved at: " + e.getX() + ", " + e.getY());
				drawingStatus = false;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("Mouse dragged at: " + e.getX() + ", " + e.getY());
				if (drawingStatus) {
					component.addBrushStroke(x1, y1, e.getX(), e.getY());
				}
				x1 = e.getX();
				y1 = e.getY();
				drawingStatus = true;
				component.repaint();
			}
		});

		// 1.3 Make sure you verify the listeners work via System.out.println
		// 1.4 When a user drags the mouse a new BrushStroke should be added
		// based upon where the mouse was PREVIOUSLY and to the new destination.
		// When the mouse is released, the PREVIOUS location should be reset
		// Thus, no BrushStrokes are added UNTIL the there is a PREVIOUS
		// location stored AND the mouse is dragged to a new location.

		// TODO Part 2 Add a Clear Button
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.reset();
				component.repaint();
			}
		});

		buttonPanel.add(clearButton);

		// TODO Part 3 Buttons for selecting colors - Red, Green, Blue, Black
		// ("R","G","B","B")
		// Note: the background/foreground (text) colors should match the same picture
		JButton redButton = new JButton("R");
		redButton.setBackground(Color.RED);
		;
		redButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setColor(Color.RED);
			}
		});
		buttonPanel.add(redButton);
		
		JButton greenButton = new JButton("G");
		greenButton.setBackground(Color.green);
		;
		greenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setColor(Color.green);
			}
		});
		buttonPanel.add(greenButton);
		
		JButton blueButton = new JButton("B");
		blueButton.setBackground(Color.blue);
		blueButton.setForeground(Color.white);
		;
		blueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setColor(Color.blue);
			}
		});
		buttonPanel.add(blueButton);
		
		JButton blackButton = new JButton("B");
		blackButton.setBackground(Color.black);
		blackButton.setForeground(Color.white);
		;
		blackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setColor(Color.black);
			}
		});
		buttonPanel.add(blackButton);
		
		
		// TODO Part 4 Buttons to Increase and Decrease Brush Size ("+", "-")
		// Note: the minimum size should be 1, you do not have to set a max size


		JButton thickButton = new JButton("+");
		;
		thickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setWidth(1);
			}
		});
		buttonPanel.add(thickButton);
		
		JButton thinButton = new JButton("-");
		;
		thinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.setWidth(-1);
			}
		});
		buttonPanel.add(thinButton);
		
		
		// TODO Part 5 Bonus Undo Button (undo ten most recent strokes)
		// Note: there should NOT be an error if pressed with fewer than 10 BrushStrokes
		// on the board and but the remaining strokes should removed

		JButton undoButton = new JButton("Undo");
		;
		undoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				component.undo();
			}
		});
		buttonPanel.add(undoButton);
		
		
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
