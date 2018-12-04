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
		
		for(GameObjects o:objects) {
			g.drawImage(o.getImage(), o.getX(), o.getY(), o.getWidth(), o.getHeight(), this);
		}
	}
	public void update(int w, int h, ArrayList<GameObjects> objects) {
		this.frameHeight = h;
		this.frameWidth = w;
		this.objects = objects;
		this.repaint();
	}
}
