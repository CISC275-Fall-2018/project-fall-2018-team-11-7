import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewGame2 extends View {
	Font font = new Font("Helvetica",Font.PLAIN,24);
	List<Animal> animals;
	boolean addMollusk = false;
	boolean removeMollusk = false;
	boolean addFish = false;
	boolean removeFish = false;
	boolean addDuck = false;
	boolean removeDuck = false;
	
	public ViewGame2(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
		JPanel drawPanel = new JPanel();
		JPanel panel = new JPanel();
		Container pane = frame.getContentPane();
    	pane.setLayout(new BorderLayout());

		//frame.add(drawPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel.setSize(frameWidth, frameHeight);
		drawPanel.setBackground(Color.white);
		JButton b1 = new JButton("add mollusk");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addMollusk = true;
				System.out.println("add mollusk");
			}
		});
		JButton b2 =new JButton("add fish");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addFish = true;
				System.out.println("add fish");
			}
		});
		JButton b3 =new JButton("add duck");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addDuck = true;
				System.out.println("add duck");
			}
		});
		JButton b4 = new JButton("remove mollusk");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				removeMollusk = true;
				System.out.println("remove mollusk");
			}
		});
		JButton b5 =new JButton("remove fish");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				removeFish = true;
				System.out.println("remove fish");
			}
		});
		JButton b6 =new JButton("remove duck");
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				removeDuck = true;
				System.out.println("remove duck");
			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		
    	pane.add(panel, BorderLayout.PAGE_END);
    	pane.add(new AnimationView2(frameWidth,frameHeight), BorderLayout.CENTER);
    	pane.setBackground(Color.gray);
    	frame.setVisible(true);
		pack();
		
		
		
	}
}
	
