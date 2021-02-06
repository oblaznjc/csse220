import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SceneComponent extends JComponent {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Get the 2D graphics object
		Graphics2D g2 = (Graphics2D) g;
		
		// Draw a sky for the Scene by drawing a blue rectangle in the upper 375 
		// pixels of the component
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, 750, 375);
		// Draw grass for the Scene by drawing a green rectangle in the rest of the component
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 375, 750, 225);

		// Create a Sun using the default (parameterless) constructor,
		// then draw it to the frame
		Sun s = new Sun();
		s.drawOn(g2);
		
		for(int i = 0; i < 5; i++) {
			House h = new House(100 + 120 * i, 450, Color.RED);
			h.drawOn(g2);
		}
		
		for(int i = 0; i < 25; i++) {
			PineTree p = new PineTree(200 + 20 * i, 345, 10, 40);
			p.drawOn(g2);	
		}
		
		for(int i = 0; i < 15; i++) {
			PineTree p = new PineTree(200 + 32 * i, 350, 20, 80);
			p.drawOn(g2);
		}
	}
}
