import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	protected int frameWidth;
	protected int frameHeight;
	JFrame frame;
	Dimension size;

	public View(int frameWidth, int frameHeight, Dimension size) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.size = size;
		//this.frameWidth = frameWidth;
		//this.frameHeight = frameHeight;
		frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		//frame.setVisible(true);
	}

	public int getWidth() {
		return frameWidth;
	}
	public int getHieght() {
		return frameHeight;
	}
	
	//void paintBackground() {}
	void updateView() {
		
	}
	void pauseView() {}

	public int getQChoice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(Camera camera, ArrayList<GameObjects> objects, int score, String target) {
		// TODO Auto-generated method stub
		
	}

	public void update(int qNum, int score, int resetQChoice) {
		// TODO Auto-generated method stub
		
	}

	//public void update(Camera camera, List<GameObjects> objects, int score, String target) {
		// TODO Auto-generated method stub
		
	//}
}
