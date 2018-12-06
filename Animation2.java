import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Animation2 extends JPanel {
	Font font = new Font("Helvetica",Font.PLAIN,24);
	int frameWidth;
	int frameHeight;
	ArrayList<GameObjects> objects;
	boolean tutorial;
	int score = 0;
	int littleFish = 0;
	int middleFish = 0;
	int bigFish = 0;
	int dayNum = 0;

	public Animation2(int frameWidth, int frameHeight, ArrayList<GameObjects> objects) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.objects = objects;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.cyan);
		g.fillRect(0, 0, frameWidth, (int)(frameHeight/4));
		g.setColor(Color.blue);
		g.fillRect(0,(int)(frameHeight/4),frameWidth,(frameHeight - frameHeight/4));
		g.setColor(Color.gray);
		g.fillRect((int)(frameWidth - frameWidth/5), (int)(frameHeight - frameHeight/4), (int)(frameWidth/5), (int)(frameHeight/4));
		g.fillRect(0, (int)(frameHeight/6), (int)(frameWidth/7), (int)(frameHeight - frameHeight/3));
		g.setColor(Color.black);
		g.drawRect(0, (int)(frameHeight/6), (int)(frameWidth/7), (int)(frameHeight/3 - frameHeight/9));
		g.drawRect(0, (int)(frameHeight/2 - frameHeight/9),(int)(frameWidth/7), (int)(frameHeight/3 - frameHeight/9));
		g.drawRect(0, (int)(frameHeight/2 + frameHeight/9), (int)(frameWidth/7), (int)(frameHeight/3 - frameHeight/9));
		g.setFont(font);
		g.drawString("Remove",(int)(frameWidth - frameWidth/7), (int)(frameHeight - frameHeight/6));
		g.drawRect((int)(frameWidth - frameWidth/5), (int)(frameHeight - frameHeight/4), (int)(frameWidth/5), (int)(frameHeight/4));
		g.drawString("Score: "+score, 50,50);
		g.drawString("Day: "+dayNum, (int)(frameWidth - 100), 50);
		for(GameObjects o:objects) {
			g.drawImage(o.getImage(), (int)(o.getX()), (int)(o.getY()), (int)(o.getWidth()), (int)(o.getHeight()), this);
		}
		if(tutorial) {
			g.drawString("As steward of the estuary, try to balance the ecosystem!", (int)(frameWidth/3), 50);
			g.drawString("Click to pick up a fish.", (int)(frameWidth/3), 150);
			g.drawString("Click again to place the fish.", (int)(frameWidth/3), 200);
			g.drawString("Click 'go to next day' to see what happens!", (int)(frameWidth/3), 250);
		}
		if(dayNum == 3) {
			g.drawString("Good Job! Press 'go to next day' to continue", (int)(frameWidth/3), 150);
		}
	}
	public void update(int w, int h, ArrayList<GameObjects> objects, boolean tutorial, int score, int dayNum) {
		this.frameHeight = h;
		this.frameWidth = w;
		this.objects = objects;
		this.tutorial = tutorial;
		this.score = score;
		this.dayNum = dayNum;
		if(dayNum<4) {
			this.repaint();
		}
	}
}
