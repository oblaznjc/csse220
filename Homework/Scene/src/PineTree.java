import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class PineTree {

	private int y;
	private int x;
	private int height;
	private int width;

	public PineTree(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public void drawOn(Graphics2D g2) {
		g2 = (Graphics2D) g2.create();

		Color brown = new Color(145, 112, 33);
		Color green = new Color(40, 135, 22);

		g2.translate(x, y);

		g2.setColor(brown);
		g2.fillRect(width / 3, height * 2 / 3, width / 3, height / 3);

		g2.setColor(green);
		int[] xPoints = { 0, width / 2, width };
		int[] yPoints = { height * 2 / 3, 0, height * 2 / 3 };
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		g2.fill(triangle);

	}

}
