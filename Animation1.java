import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class Animation1 extends JPanel {
	int frameWidth;
	int frameHeight;
	private String target = "";
	Font font = new Font("Helvetica",Font.PLAIN,24);

	Camera camera;
	List<Animal> animals;
	private int score;

	private Color myGreen;

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.cyan);
		g.fillRect(0,0,frameWidth,frameHeight/2);
		g.setColor(Color.blue);
		g.fillRect(frameWidth/2,frameHeight/2,frameWidth/2,frameHeight/2);
		g.setColor(myGreen);
		g.fillRect(0,frameHeight/2,frameWidth/2,frameHeight/2);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Score: " + score,20,60);
		g.drawString("Target: " + target,frameWidth-200,60);
		g.drawRect(camera.getX(),camera.getY(),camera.getWidth(),camera.getHeight());
		g.setColor(Color.red);
		for(Animal a: animals){
			g.drawImage(a.getImage(a.getDir()),a.getX(), a.getY(), a.getWidth(), a.getHeight(), this);
		}
	}
	
	public void update(int w, int h, Camera c, List<Animal> a, String t, int score) {
		this.frameWidth = w;
		this.frameHeight = h;
		this.camera = c;
		this.animals = a;
		this.target = t;
		this.score = score;
		this.repaint();
	}
}
	