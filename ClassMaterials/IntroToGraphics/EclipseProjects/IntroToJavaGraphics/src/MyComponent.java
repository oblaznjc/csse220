import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		// reuse original JComponent method
		// Graphics2D has more functions available
		Graphics2D g2d = (Graphics2D) g;

		Rectangle box = new Rectangle(10, 20, 30, 40); // Rectangle box = new Rectangle(x, y, width, height)
		Rectangle box2;
		
		g2d.draw(box);
		
		for(int i =10; i <= 50; i +=10) {
			box = new Rectangle(50,50, 30, 30);
			g2d.translate(30, 30);
			g2d.draw(box);

		}
		
		
		Ellipse2D.Double circle = new Ellipse2D.Double(10, 400, 20, 20);
		g2d.draw(circle);
		
	}
}
