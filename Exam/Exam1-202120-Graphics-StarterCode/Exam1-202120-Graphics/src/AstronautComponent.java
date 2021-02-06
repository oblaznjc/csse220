import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class AstronautComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawString("Part 1", 20, 20);
		g2d.drawString("Part 2", 200, 20);
		g2d.drawString("Part 3", 400, 20);
		g2d.drawString("Part 4", 20, 275);

		// -----
		// Part 1 For Astronaut, add backpack and visor
		// -----
		Astronaut astronaut1 = new Astronaut();
		astronaut1.drawOn(g2d);

		// -----
		// Part 2 For Astronaut, add 0-parameter constructor, parameterized constructor,
		// and instance variables
		// -----
		int centerX = 300;
		int centerY = 125;
		int height = 200;
		Color suitColor = Color.ORANGE;
		Astronaut astronaut2 = new Astronaut(centerX, centerY, height, suitColor);
		astronaut2.drawOn(g2d);

		// -----
		// Part 3 For Astronaut, add setOrientation method that changes the Astronaut's
		// appearance
		// -----
		centerX = 500;
		centerY = 100;
		height = 150;
		suitColor = Color.YELLOW;
		Astronaut astronaut3 = new Astronaut(centerX, centerY, height, suitColor);
		astronaut3.setOrientation("LEFT");
		astronaut3.drawOn(g2d);

		// -----
		// Part 4 - For Astronaut, add a setRotationFactor that changes the Astronaut's
		// appearance
		// -----

		// Red, right-oriented, spinning Astronaut
		centerY = 350;
		height = 80;
		suitColor = Color.RED;
		double radians = 0;
		for (centerX = 50; centerX <= 800; centerX += 100) {
			Astronaut spinningAstronaut1 = new Astronaut(centerX, centerY, height, suitColor);
			spinningAstronaut1.setRotationFactor(radians);
			spinningAstronaut1.drawOn(g2d);
			radians += Math.PI / 8;
		} // end for

		// Blue, left-oriented, spinning Astronaut
		centerY = 450;
		height = 80;
		suitColor = Color.BLUE;
		radians = 0;
		for (centerX = 40; centerX <= 800; centerX += 100) {
			Astronaut spinningAstronaut2 = new Astronaut(centerX, centerY, height, suitColor);
			spinningAstronaut2.setOrientation("LEFT");
			spinningAstronaut2.setRotationFactor(radians);
			spinningAstronaut2.drawOn(g2d);
			radians += Math.PI / 8;
		} // end for

	} // paintComponent
} // AstronautComponent
