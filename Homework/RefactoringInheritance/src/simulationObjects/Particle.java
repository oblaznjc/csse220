package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.util.Random;

/**
 * The Particle class consists of a black circle which moves and bounces off the
 * boundaries of the spaces it is inside as well as other particles.
 * 
 * @author Jacob Oblazny
 * 
 *         TODO: Part 2 You can change and should change anything you wish to in
 *         this file
 *
 */
public class Particle extends SimulationObject {

	// Unique to Particle
	public static final int PARTICLE_RADIUS = 10;
	public static final int PARTICLE_SPEED = 5;
	public static final Color PARTICLE_COLOR = Color.BLACK;

	public Particle(int x, int y) {
		super(x, y);

		/////// START - THIS CODE IS UNIQUE TO PARTICLE
		setRadius(PARTICLE_RADIUS);
		setMoveSpeed(PARTICLE_SPEED);
		setColor(PARTICLE_COLOR);
		/////// END - THIS CODE IS UNIQUE TO PARTICLE

		normalizeVelocity();
	}
}
