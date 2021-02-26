package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Stroke;

/**
 * This class represents a single brush stroke starting from one location and
 * moving to another. It also have a particular color and stroke size.
 * 
 * @author oblaznjc
 *
 */
public class BrushStroke extends BasicStroke {

	// ------
	// TODO: Add instance variables
	// ------

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	private int width = 1;

	// ------
	// TODO: Add constructors
	// ------

	public BrushStroke(int x1, int y1, int x2, int y2, Color color, int width) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		this.width = width;
	}

	/**
	 * 
	 * @param g2d
	 */
	public void drawOn(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.width));
		g2d.drawLine(x1, y1, x2, y2);
	} // drawOn

}
