import java.awt.Color;
import java.awt.Graphics2D;

public class Sun {

	private static final Color BORDER_COLOR = Color.BLACK;
	private static final int NUMBER_OF_RAYS = 8;
	private static final double RAY_LENGTH_SCALE = 0.5;
	private static final double RAY_WIDTH_SCALE = 0.1;
	private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	private static final double DEFAULT_SUN_DIAMETER = 100.0;
	private static final double DEFAULT_SUN_X = 100.0;
	private static final double DEFAULT_SUN_Y = 100.0;
	private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	private static final double LITTLE_SUNS_X_OFFSET = 50;

	private double x; // a double representing the x position of the upper left corner of the bounding
						// box of the Sun's center circle
	private double y; // a double representing the y position of the upper left corner of the bounding
						// box of the Sun's center circle
	private int circleDiameter; // diameter of the center circle of a Sun
	private int rayLength; // the length of each ray of a Sun
	private int rayWidth; // the width of each ray of a Sun
	private int rayDistanceFromSun; // the distance from the center of the sun to the beginning of a ray
	private Color color; // the fill color for the Sun

	public Sun() {
		this.x = DEFAULT_SUN_X;
		this.y = DEFAULT_SUN_Y;
		this.circleDiameter = (int) DEFAULT_SUN_DIAMETER;
		this.color = DEFAULT_SUN_COLOR;
		
	}

	public Sun(double x, double littleSunsY, double littleSunSize, Color littleSunColor) {
		this.x = x;
		this.y = littleSunsY;
		this.circleDiameter = (int) littleSunSize;
		this.color = littleSunColor;
	}

	public void drawOn(Graphics2D g2) {
		g2 = (Graphics2D) g2.create();

		g2.translate(this.x, this.y);

		g2.setColor(this.color);
		g2.fillOval(0, 0, this.circleDiameter, this.circleDiameter);
		
		g2.setColor(BORDER_COLOR);
		g2.drawOval(0, 0,  this.circleDiameter,  this.circleDiameter);
		
		g2.translate(this.circleDiameter / 2, this.circleDiameter / 2);
		for(int i = 0; i < 8; i++) {
			this.drawRay(g2, Math.PI / 4 * i);
		}
		
		
		
	}
	
	public void drawRay(Graphics2D g2, double d) {
		rayDistanceFromSun = (int) (this.circleDiameter * RAY_DISTANCE_FROM_SUN_SCALE);
		rayLength = (int) (this.circleDiameter * RAY_LENGTH_SCALE);
		rayWidth = (int) (this.circleDiameter * RAY_WIDTH_SCALE);
		
		g2.rotate(d);
		
		g2.setColor(this.color);
		g2.fillRect(0 , - this.circleDiameter / 2 - rayDistanceFromSun - rayLength, rayWidth, rayLength);
		
		g2.setColor(BORDER_COLOR);
		g2.drawRect(0 , - this.circleDiameter / 2 - rayDistanceFromSun - rayLength, rayWidth, rayLength);
	}


}
