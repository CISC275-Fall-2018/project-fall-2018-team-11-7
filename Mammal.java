import java.awt.image.BufferedImage;

public class Mammal extends Animal {
	BufferedImage[] MammalImages;
	
	public Mammal(int width, int height, Direction dir) {
		imageWidth = width;
		imageHeight = height;
		d = dir;
		xvel = 4;
		yvel = 4;
	}
	
	void move() {
		this.updatePosition();
	}
}
