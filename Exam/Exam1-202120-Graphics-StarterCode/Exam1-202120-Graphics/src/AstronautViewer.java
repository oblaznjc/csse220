import javax.swing.JComponent;
import javax.swing.JFrame;


public class AstronautViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		int frameWidth = 800;
		int frameHeight = 550;

		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("Graphics Question");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 200);
		
		JComponent component = new AstronautComponent();
		frame.add(component);

		frame.setVisible(true);

	}

}
