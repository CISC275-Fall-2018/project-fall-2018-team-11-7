package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GameObjects.GameObjects;

import java.awt.Image;

import javax.swing.JFrame;

public class ViewGame3 extends View {
	Font font = new Font("Helvetica",Font.PLAIN,45);
	JFrame frame;
	Animation3 a;
	Image[] questions = new Image[3];
	int questionNum = 0;
	ArrayList<Integer> answerChoices = new ArrayList<Integer>();
	int score;
	int qchoice = 0;
	ArrayList<GameObjects> objects;

	public ViewGame3(int imageWidth, int imageHeight, Dimension size, ArrayList<GameObjects> objects, int score1, int score2) throws IOException {
		super(imageWidth, imageHeight,size);
		this.objects = objects;
		System.out.println(objects);
				//Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setPreferredSize(size);
    	pane.setLayout(new BorderLayout());
    	a = new Animation3(objects, score1, score2);
    	pane.add(a, BorderLayout.CENTER);

		JButton b1 = new JButton("A");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(1);
				qchoice = 1;
			}
		});
		b1.setPreferredSize(new Dimension((int)(frameWidth/4), 30));
		JButton b2 =new JButton("B");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(2);
				qchoice = 2;
			}
		});
		JButton b3 =new JButton("C");
		b2.setPreferredSize(new Dimension((int)(frameWidth/4), 30));
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(3);
				qchoice = 3;
			}
		});
		b3.setPreferredSize(new Dimension((int)(frameWidth/4), 30));
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
    	pane.add(this, BorderLayout.PAGE_START);
    	frame.setVisible(true);
    	frame.pack();
	}

	/*public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(questions[questionNum], 0, 0, 1600,1000,this);
		g.drawString("Score: " + score,20,60);
	}*/

	public void update(int questionNum, int score, int reset, boolean tutorial) {
		this.score = score;
		this.questionNum = questionNum;
		this.qchoice = reset;
		this.tutorial = tutorial;
		a.update(this.frameWidth, this.frameHeight, this.questionNum, this.score, this.tutorial);
		this.repaint();
		try {
			Thread.sleep(50);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
	public int getQChoice() {
		return qchoice;
	}
	public void setQChoice(int i) {
		this.qchoice = i;
	}
	public ArrayList<GameObjects> getObjects(){
		return objects;
	}
	public Animation3 getAnimation() {
		return a;
	}

}