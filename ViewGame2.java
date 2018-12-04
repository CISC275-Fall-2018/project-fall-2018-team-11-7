import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewGame2 extends View {
	Font font = new Font("Helvetica",Font.PLAIN,45);

	Animation2 a;
	ArrayList<GameObjects> objects;
	boolean next = false;

	public ViewGame2(int imageWidth, int imageHeight, Dimension size, ArrayList<GameObjects> objects, MouseListener mouseinput2) throws IOException {
		super(imageWidth, imageHeight,size);
		this.objects = objects;
				//Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		//frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setPreferredSize(size);
    	pane.setLayout(new BorderLayout());
    	JButton b = new JButton("Go to next day");
    	b.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			next = true;
    		}
    	});
    	this.add(b);
    	pane.add(this, BorderLayout.PAGE_END);
    	a = new Animation2(imageWidth, imageHeight, objects);
    	a.addMouseListener(mouseinput2);
    	pane.add(a, BorderLayout.CENTER);
	}

	/*public void paint(Graphics g) {
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
	}*/

	public void update(ArrayList<GameObjects> objects) {
		this.objects = objects;
		a.update(frameWidth, frameHeight, objects);
		this.repaint();
		try {
			Thread.sleep(50);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}

	@Override
	public boolean getNext() {
		return next;
	}
	@Override
	public void setNext(boolean b) {
		this.next = b;
	}

}
