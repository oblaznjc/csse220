package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ArtComponent extends JComponent {

	private ArrayList<BrushStroke> brushStrokes = new ArrayList<>();
	private Color color = Color.BLACK;
	private int width = 1;

	// TODO you may want to add additional methods here

	public void addBrushStroke(int x1, int y1, int x2, int y2) {
		brushStrokes.add(new BrushStroke(x1, y1, x2, y2, this.color, this.width));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// This is for quick reference, feel free to comment it out
//		g2d.drawString("Part 1 ( required ) - Make allow user to draw in here", 20, 20);
//		g2d.drawString("Part 2 ( required ) - Allow user to clear this canvas", 20, 40);
//		g2d.drawString("Part 3 ( opt. 1/2 ) - Allow user to choose new colors", 20, 60);
//		g2d.drawString("Part 4 ( opt. 2/2 ) - Allow user to choose brush size", 20, 80);
//		g2d.drawString("Bonus  ( not req. ) - Allow user to undo ten strokes", 20, 100);

		// Example of drawing a brush stroke for reference
		// Comment this out (Part 1)
//		g2d.setColor(Color.BLUE);
//		g2d.setStroke(new BasicStroke(10));
//		g2d.drawLine(200, 200, 220, 230);

		// TODO draw anything added by the user

		for (BrushStroke b : this.brushStrokes) {
			b.drawOn(g2d);
		}

	} // paintComponent

	public void reset() {
		this.brushStrokes.clear();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int width) {
		this.width += width;
		if (this.width <= 1) {
			this.width = 1;
		}
	}

	public void undo() {
		int numToRemove = Math.min(this.brushStrokes.size(), 10);
		for (int i = 0; i < numToRemove; i++) {
			this.brushStrokes.remove(this.brushStrokes.size() - 1);
		}
		this.repaint();

	}
} // ArtComponent
