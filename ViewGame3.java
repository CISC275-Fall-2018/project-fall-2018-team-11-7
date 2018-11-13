import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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

import javax.swing.JFrame;

public class ViewGame3 extends View {
	JFrame frame;
	Container pane;
	JPanel panel;
	String[][] questions = {{"What do horseshoe crabs like to eat?", "clams","grass","birds"},{"Where do birds like to live?","water","trees", "burrows"}};
	int questionNum = 0;
	ArrayList<Integer> answerChoices = new ArrayList<Integer>();
	int[] answerKey = {1,2};
	
	public ViewGame3() {
		frame = new JFrame();
		pane = frame.getContentPane();
    	pane.setLayout(new BorderLayout());
    	panel = new JPanel();
		JButton b1 = new JButton(questions[questionNum][1]);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(1);
				System.out.println("Button 1 working");
				System.out.println(answerChoices);
				switchQuestions();
			}
		});
		JButton b2 =new JButton(questions[questionNum][2]);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(2);
				System.out.println("Button 2 working");
				System.out.println(answerChoices);
				switchQuestions();
			}
		});
		JButton b3 =new JButton(questions[questionNum][3]);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answerChoices.add(3);
				System.out.println("Button 3 working");
				System.out.println(answerChoices);
				switchQuestions();
			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
		
		
    	pane.add(panel, BorderLayout.PAGE_END);
    	pane.setBackground(Color.gray);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
	}
	
	void paint() {}
	
	void switchQuestions() {
		if(questionNum < questions.length-1) {
			questionNum++;
		}
		else {
			///end the game
		}
	}
	
	/*Button buttonAnswer1() {
		return null;
	}
	Button buttonAnswer2() {
		return null;
	}
	Button buttonAnswer3() {
		return null;
	}*/
	
	public static void main(String[] args) {
		//Here solely for the purpose of testing
		ViewGame3 view = new ViewGame3();
	}
}
