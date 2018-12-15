package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GameObjects.GameObjects;

public class Animation3 extends JPanel {
	Font font1 = new Font("Helvetica",Font.PLAIN,24);
	Font font2 = new Font("Helvetica",Font.PLAIN,30);
	int frameWidth;
	int frameHeight;
	String[] questions = {"What do Shore Birds like to eat?","Grass","Horseshoe Crab eggs","Frogs","Where do fish live?","Trees","Burrows","Water","What do frogs like to eat?", "Leaves","Insects","Acorns", "When can herons be found in Delaware?","Summer","Winter","All year", "Where do ducks like to live?","Near water", "In parks", "In forrests"};
	int questionNum = 0;
	int score = 0;
	int score1;
	int score2;
	private Color myGreen;
	private ArrayList<GameObjects> objects;
	boolean tutorial;
	BufferedImage image;

	public Animation3(ArrayList<GameObjects> objects, int score1, int score2) throws IOException {
		this.objects = objects;
		myGreen = new Color(0,140,0);
		this.score1 = score1;
		this.score2 = score2;
		try {
			image = ImageIO.read(new File("images/skylandnsea.jpg"));
					// ImageIO.read("src/skynsea.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		/*g.setColor(Color.cyan);
		g.fillRect(0,0,frameWidth,frameHeight/2);
		g.setColor(Color.blue);
		g.fillRect(frameWidth/2,frameHeight/2,frameWidth/2,frameHeight/2);
		g.setColor(myGreen);
		g.fillRect(0,frameHeight/2,frameWidth/2,frameHeight/2);
		for(GameObjects o:objects) {
			g.drawImage(o.getImage(), o.getX(), o.getY(), o.getWidth(), o.getHeight(), this);
		}*/
		g.drawImage(image, 0, 0, frameWidth, frameHeight, this);
		g.setFont(font1);
		g.setColor(Color.black);
		if(tutorial) {
			g.drawString("Learn the correct answers so you can teach others!", (int)(frameWidth/3), 100);
			g.drawString("Click the button with your answer choice", (int)(frameWidth/3), 150);
		}
		if(questionNum<5) {
			g.drawString(questions[4*questionNum], (int)(frameWidth/3),300);
			g.drawString("A - "+questions[4*questionNum + 1], (int)(frameWidth/3), 400);
			g.drawString("B - "+questions[4*questionNum + 2], (int)(frameWidth/3), 400 + g.getFontMetrics().getHeight());
			g.drawString("C - "+questions[4*questionNum + 3], (int)(frameWidth/3), 400 + 2 * g.getFontMetrics().getHeight());
			g.drawString("Score: " + score,50,60);
		}
		else {
			g.setFont(font2);
			g.setColor(Color.black);
			g.drawString("Good Job!", (frameWidth/2 - frameWidth/8), 50);
			g.drawString("Your Score for Game 1: " + score1, (frameWidth/2 - frameWidth/8), (frameHeight/2 - 100));
			g.drawString("Your Score for Game 2: " + score2, (frameWidth/2 - frameWidth/8), (frameHeight/2-50));
			g.drawString("Your Score for Game 3: "+ score+" out of 50", (frameWidth/2 - frameWidth/8), (frameHeight/2));
			g.drawString("Total Score: "+(score1+score2+score), (frameWidth/2 - frameWidth/8), (frameHeight/2 +100));
		}
	}

	public void update(int w, int h, int questionNum, int score, boolean tutorial) {
		this.frameHeight = h;
		this.frameWidth = w;
		this.questionNum = questionNum;
		this.score = score;
		this.tutorial = tutorial;
		this.repaint();
	}
	
	public int getScore() {
		return score;
	}
	public int getNum() {
		return questionNum;
	}
}
