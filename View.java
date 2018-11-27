import javax.swing.JFrame;

public class View extends JFrame {
	private int frameWidth;
	private int frameHeight;
	JFrame frame;

	public View(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setVisible(true);
	}

	void paintBackground() {}
	void updateView() {
		
	}
	void pauseView() {}
}
