
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * A component that stores, updates, and displays a variety of different Sprites
 * 
 * Modify this class as you need
 * 
 * 
 */
public class RPSComponent extends JComponent {

	// You can modify this list or add other lists as you see fit
	// This list is used inside of the paintComponent() and update() methods.
	public ArrayList<Sprite> sprites = new ArrayList<>();
	private int time;

	// This constructor initializes a single box
	public RPSComponent() {

		// Part 0 - Sample Code
		Sprite cloudSprite = new Sprite(20, 320, 80, 80, 2, 0, "img/cloud.png");
		sprites.add(cloudSprite);

		Sprite cannonSprite = new Sprite(500, 300, 80, 80, 0, 0, "img/cannon.png");
		sprites.add(cannonSprite);

		// Part 3 - uncomment these when you get to part 3+

		// Rock1 should start at (20,100), with an x-velocity 0 and y-velocity +5
		Rock rock1 = new Rock(20, 100, 0, 5);
		this.sprites.add(rock1);
		Rock rock2 = new Rock(20, 200, 0, -5);
		this.sprites.add(rock2);

		// Paper
		Paper paper1 = new Paper(200, 110, -5, 0);
		this.sprites.add(paper1);
		Paper paper2 = new Paper(200, 210, 5, 0);
		this.sprites.add(paper2);

		// Scissors
		Scissors scissors1 = new Scissors(400, 110, 5, 0);
		this.sprites.add(scissors1);
		Scissors scissors2 = new Scissors(400, 210, -5, 0);
		this.sprites.add(scissors2);

	}

	// This method should draw anything considered to be part of the Component
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// provided code - images drawn on screen for demonstration
		// This can be left here or commented out
		g2.drawString("Part 0: Sample Sprite", 5, 290);

		// Part 1: Tracking time
		g2.drawString("Part 1", 5, 10);
		g2.drawString("Time:" + this.time, 50, 10);

		// Part 2: Rocks
		g2.drawString("Part 2: Rocks", 5, 100);

		// Part 3: Papers
		g2.drawString("Part 3: Papers", 200, 100);

		// Part 4: Scissors
		g2.drawString("Part 4: Scissors", 400, 100);

		// Part 5: Spawn Sprites
		g2.drawString("Part 5: Spawn Point", 420, 380);

		// Draw all sprites and check for collisions
		for (Sprite s : sprites) {
			s.drawOn(g2);
		}

	}

	// You may want a method like this
	public void update() {

		this.time += 1;

		// TODO figure out what else might be useful to put in here
		for (Sprite s : this.sprites) {
			if (s.toRemove) {
				this.sprites.remove(s);
				return;
			}
			s.update(this.getSize());
			for (Sprite o : sprites) {
				if (s != o & s.overlapsWith(o)) {
					s.collideWith(o);
				}
			}
		}
		this.repaint();
	}

	public void timeStep() {
		update();

	}
}
