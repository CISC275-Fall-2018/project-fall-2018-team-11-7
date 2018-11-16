import javax.swing.JFrame;

public class View extends JFrame {
	private int frameWidth;
	private int frameHeight;

	public View(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}

	void paintBackground() {}
	void updateView() {}
	void pauseView() {}
}
