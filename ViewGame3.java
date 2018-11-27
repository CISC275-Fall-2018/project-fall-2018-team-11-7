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

import java.awt.Image;

import javax.swing.JFrame;

public class ViewGame3 extends View {
	Font font = new Font("Helvetica",Font.PLAIN,45);
	JFrame frame;
	JPanel panel;
	Animation3 a;
	Image[] questions = new Image[3];
	int questionNum = 0;
	ArrayList<Integer> answerChoices = new ArrayList<Integer>();
	int score;
	int qchoice = 0;
	
	public ViewGame3(int imageWidth, int imageHeight, Dimension size) throws IOException {
		super(imageWidth, imageHeight,size);
		
				//Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
		frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setPreferredSize(size);
    	pane.setLayout(new BorderLayout());
    	a = new Animation3();
    	pane.add(a, BorderLayout.CENTER);
    	panel = new JPanel();
    	
		JButton b1 = new JButton("A");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(1);
				System.out.println("Button 1 working");
				qchoice = 1;
			}
		});
		JButton b2 =new JButton("B");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(2);
				System.out.println("Button 2 working");
				qchoice = 2;
			}
		});
		JButton b3 =new JButton("C");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(3);
				System.out.println("Button 3 working");
				qchoice = 3;
			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
    	pane.add(panel, BorderLayout.PAGE_END);
    	frame.setVisible(true);
    	frame.pack();
	}
	
	/*public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(questions[questionNum], 0, 0, 1600,1000,this);
		g.drawString("Score: " + score,20,60);
	}*/
	
	public void update(int questionNum, int score, int reset) {
		this.score = score;
		this.questionNum = questionNum;
		this.qchoice = reset;
		a.update(this.frameWidth, this.frameHeight, this.questionNum, this.score);
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
