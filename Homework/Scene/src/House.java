import java.awt.Color;
import java.awt.Graphics2D;

public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;

	private Color color;
	private int y;
	private int x;
	private int height;
	private int width;
	private int roof;

	public House(int x, int y, Color color) {
		// TODO: save off the parameters into instance variables
		this.x = x;
		this.y = y;
		this.color = color;
		this.height = HEIGHT;
		this.width = WIDTH;
		this.roof = ROOF_HEIGHT;
	}

	public void drawOn(Graphics2D g2) {
		// TODO: Draw the house body (a rectangle) and the roof (3 lines or a
		// Polygon)
		g2.setColor(this.color);

		g2.drawLine(this.x, this.y, this.x + this.width / 2, this.y - this.roof);
		g2.drawLine(this.x + this.width, this.y, this.x + this.width / 2, this.y - this.roof);
		g2.fillRect(this.x, this.y, this.width, this.height);
	}

}
