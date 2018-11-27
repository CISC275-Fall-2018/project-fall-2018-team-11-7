import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class AnimationView2 {
	public AnimationView2() {
		Font font = new Font("Helvetica",Font.PLAIN,24);
		List<Animal> animals;
		boolean addMollusk = false;
		boolean removeMollusk = false;
		boolean addFish = false;
		boolean removeFish = false;
		boolean addDuck = false;
		boolean removeDuck = false;
	}
	public AnimationView2(int frameWidth, int frameHeight) {

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.cyan);
		g.fillRect(0,0,800,500);
		g.setColor(Color.blue);
		g.fillRect(0,300,800,200);
		g.setFont(font);
		g.setColor(Color.black);
		g.setColor(Color.red);
		for(Animal a: animals){
			g.drawImage(a.getImage(0),a.getX(), a.getY(), a.getWidth(), a.getHeight(), this);
		}
	}
}
