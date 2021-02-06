package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

/**
 * This class represents a Person who can either be healthy (green), infected
 * (orange), or recovered (pink). Once a Person becomes infected, they will
 * remain infected for a certain length of time before they become recovered.
 * Once recovered, the Person cannot be infected again.
 * 
 * Inspired by this article:
 * https://www.washingtonpost.com/graphics/2020/world/corona-simulator/
 * 
 * To visualize a population of Persons over time you should provide a method
 * that says if a Person isHealthy, isSick, or isRecovered.
 * 
 * This class should use inheritance to make it simple to write. You should not
 * need to copy and paste
 * 
 * TODO: Part 4 You can change this file but will need to provide each of the
 * methods started in order to get full functionality.
 * 
 * @author Jacob Oblazny
 *
 */
public class Person extends SimulationObject {

	public static final int PERSON_RADIUS = 10;
	public static final int PERSON_SPEED = 5;
	public static final double DEATH_RATE = 0.1;

	// How many timesteps to recover once infected
	public static final int TIME_TO_RECOVER = 100;

	public static final Color HEALTHY_COLOR = new Color(134, 184, 184);
	public static final Color INFECTED_COLOR = new Color(204, 102, 0);
	public static final Color RECOVERED_COLOR = new Color(196, 116, 195);
	public static final Color DEAD_COLOR = Color.BLACK;

	// TODO: add instance variables
	private boolean healthyStatus;
	private boolean infectedStatus;
	private boolean recoveredStatus;
	private int RecoveredCountDown = 0;
	private int countTransmissions;
	private boolean deadStatus;

	// TODO: add constructors

	public Person(int x, int y, boolean isInfected) {
		super(x, y);

		if (isInfected) {
			this.infectedStatus = true;
			setColor(INFECTED_COLOR);
		} else {
			this.healthyStatus = true;
			setColor(HEALTHY_COLOR);
		}
		this.recoveredStatus = false;
		this.deadStatus = false;
		this.countTransmissions = 0;
		setRadius(PERSON_RADIUS);
		setMoveSpeed(PERSON_SPEED);
		normalizeVelocity();
	}

	public void update(Dimension2D dim) {
		// TODO Update your position
		super.update(dim);

		/////// START - THIS CODE IS UNIQUE TO Person
		// This code is UNIQUE to Person
		if (this.isHealthy()) {
			setColor(HEALTHY_COLOR);
		} else if (isDead()) {
			setColor(DEAD_COLOR);
		} else if (isRecovered()) {
			setColor(RECOVERED_COLOR);
		} else if (this.RecoveredCountDown > TIME_TO_RECOVER) {
			setInfectedStatus(false);
			if (Math.random() < DEATH_RATE) {
				this.deadStatus = true;
				setColor(DEAD_COLOR);
			} else {
				this.recoveredStatus = true;
				setColor(RECOVERED_COLOR);
			}
		} else if (this.isInfected()) {
			setColor(INFECTED_COLOR);
			// countup until recovered
			++this.RecoveredCountDown;
			/////// END - THIS CODE IS UNIQUE TO Person
		}

	}

	public void checkIfInfected(Person other) {

		if (this.isHealthy() && other.isInfected()) { // I must be healthy, AND the other player MUST be infected
			// I become infected
			this.setInfectedStatus(true);
			this.healthyStatus = false;
			// The other player counts me as a transmission
			other.countTransmissions();
		}
	}

	private void countTransmissions() {
		// Counts the number of Persons this person infected
		++this.countTransmissions;
	}

	public void bounce(Person other) {
		// TODO Infect healthy people when they bounce off of infected people
		super.bounce(other);

		/////// START - THIS CODE IS UNIQUE TO Person
		// See if this got infected by someone else
		checkIfInfected(other);
		/////// END - THIS CODE IS UNIQUE TO TagPlayer
		normalizeVelocity();
	}

	public boolean isHealthy() {
		// TODO return true if this person is healthy. False if infected or recovered
		return this.healthyStatus;
	}

	public boolean isInfected() {
		// TODO return true if this person is sick. False if infected or recovered
		return this.infectedStatus;
	}

	public boolean isRecovered() {
		// TODO return true if this person is recovered. False if infected or healthy
		return this.recoveredStatus;
	}

	public boolean isDead() {
		// TODO return true if this person is recovered. False if infected or healthy
		return this.deadStatus;
	}

	public void setInfectedStatus(boolean infectedStatus) {
		this.infectedStatus = infectedStatus;
	}

}
