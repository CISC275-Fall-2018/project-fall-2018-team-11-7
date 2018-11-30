import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import java.util.List;

public class ViewGame1 extends View{
	private String target = "";
	Font font = new Font("Helvetica",Font.PLAIN,24);

	Camera camera;
	List<Animal> animals;
	private int score;
	Tree tree;

	private Color myGreen;

	public ViewGame1(int frameWidth, int frameHeight, Dimension size) {
		super(frameWidth, frameHeight, size);
		Container pane = frame.getContentPane();
		pane.setPreferredSize(size);
		//super(frameWidth,frameHeight);
		//pane.add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

		myGreen = new Color(0,140,0);

	}

	public void update(Camera camera, List<Animal> animals,Tree tree, int score, String target){
		this.camera = camera;
		this.animals = animals;
		this.score = score;
		this.target = target;
		this.tree = tree;
		
		this.repaint();
		try {
		Thread.sleep(50);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

	/*public void updateGraphics(Graphics g) {
		Graphics offgc;
		Image offscreen = null;
		
	}*/
	
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
		g.drawImage(tree.getImage(), tree.getX(), tree.getY(), tree.getWidth(), tree.getHeight(), this);
		for(Animal a: animals){
			g.drawImage(a.getImage(a.getDir()),a.getX(), a.getY(), a.getWidth(), a.getHeight(), this);
		}
	}
}