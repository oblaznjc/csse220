package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

public class SimulationObject {
	protected int centerX;
	protected int centerY;
	protected int radius;
	private int velX;
	private int velY;
	private int moveSpeed;
	private Color color;

	public SimulationObject() {
		this(0, 0);
	}

	public SimulationObject(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		this.velX = (int) (getMoveSpeed() - Math.random() * getMoveSpeed() * 2);
		this.velY = (int) (getMoveSpeed() - Math.random() * getMoveSpeed() * 2);

		normalizeVelocity();
	}

	public void drawOn(Graphics2D g) {

		// avoid having to untranslate by mutating a copy of the graphics content
		g = (Graphics2D) g.create();
		g.setColor(this.color);
		g.translate(centerX - radius, centerY - radius);
		g.fillOval(0, 0, radius * 2, radius * 2);
	}

	public void update(Dimension2D dim) {
		centerX += velX;
		centerY += velY;
		if (centerX > dim.getWidth() || centerX < 0) {
			centerX = (int) Math.min(Math.max(centerX, 0), dim.getWidth());
			velX = -velX;
		}
		if (centerY > dim.getHeight() || centerY < 0) {
			velY = -velY;
			centerY = (int) Math.min(Math.max(centerY, 0), dim.getHeight());
		}
	}

	/**
	 * Determine if two SimulationObject collided with each other.
	 */
	public boolean overlapsWith(SimulationObject other) {
		int xDiff = centerX - other.centerX;
		int yDiff = centerY - other.centerY;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return this.getRadius() + other.getRadius() >= distance;
	}

	/**
	 * Move in opposite direction of collision with other SimulationObject.
	 */
	public void bounce(SimulationObject other) {
		this.velX = this.centerX - other.centerX;
		this.velY = this.centerY - other.centerY;
		normalizeVelocity();
	}

	protected void normalizeVelocity() {
		// move down, right if velocity is set to zero
		if (this.velX == 0 && this.velY == 0) {
			this.velX = 1;
			this.velY = 1;
		}
		// normalize vector
		double vectorLength = Math.sqrt(velX * velX + velY * velY);
		this.velX = (int) (this.velX / vectorLength * getMoveSpeed() * 2);
		this.velY = (int) (this.velY / vectorLength * getMoveSpeed() * 2);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}