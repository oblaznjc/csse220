import javax.swing.JFrame;

public class MyViewer {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		int frameWidth = 400;
		int frameHeight = 600;
		
		frame.setSize(frameWidth, frameHeight);
		frame.setTitle("I've been framed!");
		
		 MyComponent component = new MyComponent();
		frame.add(component);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setVisible(true);
	}
}
