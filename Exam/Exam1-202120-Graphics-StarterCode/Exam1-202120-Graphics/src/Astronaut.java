import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Astronaut {

	// ------
	// CONSTANTS
	// ------
	private static final int HEIGHT_TO_WIDTH_RATIO = 2; // i.e. if height=100, then width=50
	private static final int BORDER_WIDTH = 10;
	private static final Color OUTLINE_COLOR = Color.BLACK;

	private static final Color VISOR_COLOR = Color.GRAY;

	// ------
	// Default values for Astronaut
	// ------
	private static final int DEFAULT_HEIGHT = 100;
	private static final int DEFAULT_CENTER_X = 80;
	private static final int DEFAULT_CENTER_Y = 80;
	private static final Color DEFAULT_COLOR = new Color(0, 155, 0);
	private static final String DEFAULT_ORIENTATION = "RIGHT";

	// ------
	// TODO: Add instance variables
	// ------
	private int centerX;
	private int centerY;
	private int height;
	private Color suitColor;
	private String orientation;
	private double rotation;

	// ------
	// TODO: Add constructors
	// ------
	public Astronaut() {
		this.centerX = DEFAULT_CENTER_X;
		this.centerY = DEFAULT_CENTER_Y;
		this.height = DEFAULT_HEIGHT;
		this.suitColor = DEFAULT_COLOR;
		this.orientation = DEFAULT_ORIENTATION;
		this.rotation = 0;
	}

	public Astronaut(int centerX, int centerY, int height, Color suitColor) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.height = height;
		this.suitColor = suitColor;
		this.orientation = DEFAULT_ORIENTATION;
		this.rotation = 0;
	}

	public void setOrientation(String string) {
		this.orientation = string;
	}

	public void setRotationFactor(double radians) {
		this.rotation = radians;

	}

	/**
	 * 
	 * @param g2d
	 */
	private void drawAstronaut(Graphics2D g2d) {
		// ------
		// Provided code - set the stroke size, so that outlines are thick
		// ------
		g2d.setStroke(new BasicStroke(BORDER_WIDTH)); // This does not need to be changed

		// You will want to change the code below
		// You may want to comment it out for now and then use as a reference.
		// This code calculates a location and draws the "suit" for the default
		// Astronaut

		// 50 = 100 / 2
		int defaultWidth = this.height / HEIGHT_TO_WIDTH_RATIO;

		// 55 = 80 - 50 / 2
		int upperLeftX = this.centerX - defaultWidth / 2;

		// 30 = 80 - 100 / 2
		int upperLeftY = this.centerY - this.height / 2;

		g2d.rotate(this.rotation, upperLeftX + defaultWidth / 2, upperLeftY + this.height / 2);

		// DEFAULT_ORIENTATION

		if (this.orientation.equals(DEFAULT_ORIENTATION)) {

			// Draw Outline for backpack
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX - defaultWidth / 4, upperLeftY + this.height / 4, defaultWidth / 2,
					this.height / 2);

			// Draw Filled Oval for backpack
			g2d.setColor(this.suitColor);
			g2d.fillOval(upperLeftX - defaultWidth / 4, upperLeftY + this.height / 4, defaultWidth / 2,
					this.height / 2);

			// Draw Outline for suit
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX, upperLeftY, defaultWidth, this.height);

			// Draw Filled Oval for suit
			g2d.setColor(this.suitColor);
			g2d.fillOval(upperLeftX, upperLeftY, defaultWidth, this.height);

			// Draw Outline for visor
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX + defaultWidth / 4, upperLeftY + this.height / 8, defaultWidth * 3 / 4,
					this.height / 8);

			// Draw Filled Oval for visor
			g2d.setColor(VISOR_COLOR);
			g2d.fillOval(upperLeftX + defaultWidth / 4, upperLeftY + this.height / 8, defaultWidth * 3 / 4,
					this.height / 8);
		}

		// ALTERNATE_ORIENTATION, facing "LEFT"

		if (this.orientation.equals("LEFT")) {

			// Draw Outline for backpack
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX + defaultWidth * 3 / 4, upperLeftY + this.height / 4, defaultWidth / 2,
					this.height / 2);

			// Draw Filled Oval for backpack
			g2d.setColor(this.suitColor);
			g2d.fillOval(upperLeftX + defaultWidth * 3 / 4, upperLeftY + this.height / 4, defaultWidth / 2,
					this.height / 2);

			// Draw Outline for suit
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX, upperLeftY, defaultWidth, this.height);

			// Draw Filled Oval for suit
			g2d.setColor(this.suitColor);
			g2d.fillOval(upperLeftX, upperLeftY, defaultWidth, this.height);

			// Draw Outline for visor
			g2d.setColor(OUTLINE_COLOR);
			g2d.drawOval(upperLeftX, upperLeftY + this.height / 8, defaultWidth * 3 / 4, this.height / 8);

			// Draw Filled Oval for visor
			g2d.setColor(VISOR_COLOR);
			g2d.fillOval(upperLeftX, upperLeftY + this.height / 8, defaultWidth * 3 / 4, this.height / 8);
		}
		g2d.rotate(-this.rotation, upperLeftX + defaultWidth / 2, upperLeftY + this.height / 2);

		// end Provided code

		// ------
		// TODO: #1: Move pen to a proper position to draw astronaut
		// ------

		// ------
		// For Part 3
		// TODO: Calculate position of "LEFT"/"RIGHT" orientation for
		// a) backpack position
		// b) visor position
		// ------

		// -----
		// TODO: #2 Draw the backpack
		// (centered horizontally on left/right side of suit's bounding rectangle)
		// 1/2 full width
		// 1/2 full height
		// -----

		// -----
		// TODO: #3 Draw the suit
		// full width
		// full height
		// -----

		// -----
		// TODO: #4 Draw the visor (looks like a face shield)
		// aligned to be even with left/right side of suit's bounding rectangle
		// 3/4 full width
		// 1/8 full height
		// -----

		// -----
		// TODO: If necessary, reset the 'g2d' graphics context back to its original
		// settings
		// -----

	} // drawAstronaut

	public void drawOn(Graphics2D g2d) {
		drawAstronaut(g2d);
	} // drawOn

}
