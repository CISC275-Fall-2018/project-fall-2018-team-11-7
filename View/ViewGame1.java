package View;
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

import GameObjects.Camera;
import GameObjects.GameObjects;
import GameObjects.Tree;

import java.util.ArrayList;
import java.util.List;

public class ViewGame1 extends View{
	private String target = "";
	Font font = new Font("Helvetica",Font.PLAIN,24);

	Camera camera;
	List<GameObjects> objects;
	private int score;
	Tree tree;
	boolean init = true;
	String fact = " ";
	int time = 0;

	private Color myGreen;

	public ViewGame1(int frameWidth, int frameHeight, Dimension size, Camera camera, ArrayList<GameObjects> objects) throws IOException {
		super(frameWidth, frameHeight, size);
		this.camera = camera;
		this.objects = objects;
		this.tutorial = true;
		//tutorialBird = new Bird((int)(frameWidth - frameWidth/10),(int)(frameHeight/7),(frameWidth/28),(frameWidth/52),frameWidth - frameWidth/5,0);
		//Container pane = frame.getContentPane();
		//pane.setPreferredSize(size);
		//super(frameWidth,frameHeight);
		//pane.add(panel, BorderLayout.CENTER);

		myGreen = new Color(0,140,0);

	}
	@Override
	public void update(Camera camera, ArrayList<GameObjects> objects, int score, String target, boolean tutorial, String fact, int time){
		this.camera = camera;
		this.objects = objects;
		this.score = score;
		this.target = target;
		this.tutorial = tutorial;
		this.fact = fact;
		this.time = time;

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

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(init){
			g.setColor(Color.cyan);
			g.fillRect(0,0,frameWidth,frameHeight/2);
			g.setColor(Color.blue);
			g.fillRect(frameWidth/2,frameHeight/2,frameWidth/2,frameHeight/2);
			g.setColor(myGreen);
			g.fillRect(0,frameHeight/2,frameWidth/2,frameHeight/2);
			g.setFont(font);
			//init = false;
		}
		g.setColor(Color.black);
		g.drawString("Score: " + score,20,60);
		g.drawString("Time: " + time,frameWidth-150,60);
		g.drawString("Target: " + target,(int)(frameWidth/2)-75,60);
		g.drawRect(camera.getX(),camera.getY(),camera.getWidth(),camera.getHeight());
		for(GameObjects o: objects){
			g.drawImage(o.getImage(),o.getX(), o.getY(), o.getWidth(), o.getHeight(), this);
		}
		if(score > 0 && score<=5) {
			g.drawString("Good Job! "+fact, (int)(frameWidth/2 - frameWidth/8), (int)(frameHeight/2 - frameHeight/9));
		}
		if(tutorial) {
			g.drawString("As a researcher, you are taking pictures of the wildlife in the estuary",(int)(frameWidth/2), (int)(frameHeight/4)-50);
			g.drawString("Move the mouse to move the camera.",(int)(frameWidth/2), (int)(frameHeight/4));
			g.drawString("Click to take a picture.", (int)(frameWidth/2), (int)(frameHeight/4)+50);
			g.drawString("Take a picture of the target animal to get a point!", (int)(frameWidth/2), (int)(frameHeight/4)+100);
			g.drawString("Take a picture of a "+target+" to start the game!", (int)(frameWidth/2), (int)(frameHeight/4)+150);
		}
		if(score == 5) {
			g.drawString("Great Job! Now capture as many pictures as you can for your research within 60 seconds!", (int)(frameWidth/3) - 50, 200);
		}
		if(time == 0) {
			g.drawString("Fantastic, you scored " + score + " points! Click anywhere to continue.", (int)(frameWidth/3) - 50, 100);
		}
	}
}
