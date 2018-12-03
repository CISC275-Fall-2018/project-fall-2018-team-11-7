import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewGame2 extends View {
	Font font = new Font("Helvetica",Font.PLAIN,45);
	JFrame frame;
	//JPanel panel;
	Image[] questions = new Image[3];
	ArrayList<GameObjects> objects;
	
	public ViewGame2(int imageWidth, int imageHeight, Dimension size, ArrayList<GameObjects> objects) throws IOException {
		super(imageWidth, imageHeight,size);
		this.objects = objects;
		System.out.println(objects);
				//Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		//frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    	pack();
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
	
	public void update() {
		this.repaint();
		try {
			Thread.sleep(100);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
	
	/*public static void main(String[] args) {
		//Here solely for the purpose of testing
		try {
			DummyController3 c = new DummyController3();
			c.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}*/
}
