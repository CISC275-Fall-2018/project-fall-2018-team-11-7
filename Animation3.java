import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Animation3 extends JPanel {
	Font font1 = new Font("Helvetica",Font.PLAIN,24);
	Font font2 = new Font("Helvetica",Font.PLAIN,30);
	Image[] questions = new Image[4];
	int questionNum = 0;
	int score = 0;
	
	public Animation3() throws IOException {
		File file1 = new File("Question1.png");
		File file2 = new File("Question2.png");
		File file3 = new File("Question3.png");
		File file4 = new File("end.png");
		if(file1.exists() && file2.exists() && file3.exists() && file4.exists()) {
			BufferedImage image1 = ImageIO.read(file1);
			questions[0] = image1;
			BufferedImage image2 = ImageIO.read(file2);
			questions[1] = image2;
			BufferedImage image3 = ImageIO.read(file3);
			questions[2] = image3;
			BufferedImage image4 = ImageIO.read(file4);
			questions[3] = image4;
			
		}
		
	/*	BufferedImage background1 = Toolkit.getDefaultToolkit().createImage("Question1.png");
		questions[0] = background1;
		Image background2 = Toolkit.getDefaultToolkit().createImage("Question2.png");
		questions[1] = background2;
		Image background3 = Toolkit.getDefaultToolkit().createImage("Question3.png");
		questions[2] = background3;*/
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(questions[questionNum], 0, 0, 1600,1000,this);
		g.setFont(font1);
		g.setColor(Color.black);
		if(questionNum<3) {
			g.drawString("Score: " + score,800,60);
		}
		else {
			g.setFont(font2);
			g.setColor(Color.black);
			g.drawString("Your Score: "+ score+" out of 3", 700, 600);
		}
	}
	
	public void update(int questionNum, int score) {
		this.questionNum = questionNum;
		this.score = score;
		this.repaint();
	}
}
