import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Bckgrnd extends JPanel {
	private Image image;


	public Bckgrnd() {
		
		try {
			image = ImageIO.read(new File("skylandnsea.jpg"));
					// ImageIO.read("src/skynsea.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	public static void main(String[] args) throws IOException {
		Bckgrnd bg = new Bckgrnd();
		JFrame frame = buildFrame();
		frame.add(bg);
	}
	
	
	private static JFrame buildFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);;
		frame.setVisible(true);;
		return frame;
	}
}
/*	Image img;
	public Bckgrnd() {
		img = Toolkit.getDefaultToolkit().createImage("skynsea.jpg");
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}*/
