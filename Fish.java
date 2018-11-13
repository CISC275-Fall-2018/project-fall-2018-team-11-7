import java.awt.image.BufferedImage;

public class Fish extends Animal{
	BufferedImage[] fishImages;
	
	public Fish(int width, int height, Direction dir) {
		imageWidth = width;
		imageHeight = height;
		d = dir;
		xvel = 4;
		yvel = 4;
	}
	
	void Move() {
		this.updatePosition();
	}
}
