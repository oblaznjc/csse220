package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class ChargedParticle extends Particle {
	private Color vRingColor;
	private Color wRingColor;
	private Color newParticleColor;

	public ChargedParticle(int x, int y) {
		super(x, y);
		randomizeColor();
	}

	public void drawOn(Graphics2D g) {
		super.drawOn(g);
		// avoid having to untranslate by mutating a copy of the graphics content
		g = (Graphics2D) g.create();
		g.translate(centerX - radius, centerY - radius);
		g.setColor(this.wRingColor);
		g.drawOval(-radius, radius / 2, radius * 4, radius);
		g.setColor(this.vRingColor);
		g.drawOval(radius / 2, -3 / 2 * radius, radius, radius * 4);
	}

	public void bounce(SimulationObject other) {
		super.bounce(other);
		normalizeVelocity();
		/////// START - THIS CODE IS UNIQUE TO ChargedParticle
		// See if this bounced off another particle or charged particle
		randomizeColor();
		/////// END - THIS CODE IS UNIQUE TO ChargedParticle
	}

	private void randomizeColor() {
		Random r = new Random();
		this.vRingColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		this.wRingColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		this.newParticleColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		setColor(newParticleColor);
	}
}
