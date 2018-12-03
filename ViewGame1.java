import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
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

import java.util.ArrayList;
import java.util.List;

public class ViewGame1 extends View{
	private String target = "";
	Font font = new Font("Helvetica",Font.PLAIN,24);

	Camera camera;
	List<GameObjects> objects;
	private int score;
	Tree tree;

	private Color myGreen;

	public ViewGame1(int frameWidth, int frameHeight, Dimension size, Camera camera, ArrayList<GameObjects> objects) {
		super(frameWidth, frameHeight, size);
		this.camera = camera;
		this.objects = objects;
		//Container pane = frame.getContentPane();
		//pane.setPreferredSize(size);
		//super(frameWidth,frameHeight);
		//pane.add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

		myGreen = new Color(0,140,0);

	}
	@Override
	public void update(Camera camera, ArrayList<GameObjects> objects, int score, String target){
		this.camera = camera;
		this.objects = objects;
		this.score = score;
		this.target = target;
		
		this.repaint();
		try {
		Thread.sleep(100);
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
		for(GameObjects o: objects){
			g.drawImage(o.getImage(),o.getX(), o.getY(), o.getWidth(), o.getHeight(), this);
		}
	}
}