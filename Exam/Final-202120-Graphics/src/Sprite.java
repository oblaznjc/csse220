
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * This provided class allows you to specify the location, size, velocity, and
 * image to be drawn. This class can be extended by other classes to add
 * additional functionality
 * 
 * You may modify this class in anyway you choose, but you should strive for a
 * good design which would be easy to re-use and extend.
 *
 */
public class Sprite {

	protected int x, y, width, height, dx, dy;
	protected BufferedImage img;
	protected boolean toRemove = false;
	protected String type = "";

	public Sprite(int x, int y, int w, int h, int dx, int dy, String imgFilename) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.width = w;
		this.height = h;
		// Read the filename specified to be used to draw the Sprite in the future
		try {
			this.img = ImageIO.read(new File(imgFilename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void drawOn(Graphics2D g2) {
		g2.drawImage(img, x, y, width, height, null);
	}

	/**
	 * This method will determine if two Sprite overlap or not
	 * 
	 * 
	 * @param o - another Sprite
	 * @return boolean representing whether they overlap (true) or not (false)
	 */
	public boolean overlapsWith(Sprite o) {
		Rectangle thisBoundingBox = new Rectangle(x, y, width, height);
		Rectangle otherBoundingBox = new Rectangle(o.x, o.y, o.width, o.height);
		return thisBoundingBox.intersects(otherBoundingBox);
	}

	/**
	 * This method takes a given dimension used as the boundaries in which a Sprite
	 * should move It then updates the x and y position of the Sprite using the
	 * velocity defined by dx and dy If the Sprite reaches the end of the boundaries
	 * it stops moving in that direction (x or y) and instead moves in the opposite
	 * direction (x or y)
	 * 
	 * @param dim representing the legal boundaries for the Sprites to be located
	 */
	public void update(Dimension2D dim) {
		this.x += dx;
		this.y += dy;

		// if hit the left or right edge, move back within the boundary and move in
		// opposite direction
		if (this.x + this.width > dim.getWidth() || this.x < 0) {
			this.x = (int) Math.min(Math.max(this.x, 0), dim.getWidth() - this.width);
			dx = -dx;

		}
		// if hit the top or bottom edge, move back within the boundary and move in
		// opposite direction
		if (this.y + this.height > dim.getHeight() || y < 0) {
			this.y = (int) Math.min(Math.max(this.y, 0), dim.getHeight() - this.height);
			dy = -dy;
		}
	}

	public void collideWith(Sprite o) {
	}
}
