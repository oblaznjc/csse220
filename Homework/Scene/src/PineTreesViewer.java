import java.awt.Dimension;
import javax.swing.JFrame;

public class PineTreesViewer {
	public static final Dimension PINE_TREES_VIEWER_SIZE = new Dimension(500, 400);

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(PINE_TREES_VIEWER_SIZE);
		frame.setTitle("I see Pine Trees!");

		frame.add(new PineTreesComponent());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
