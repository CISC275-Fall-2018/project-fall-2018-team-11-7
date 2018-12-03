import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LittleFish extends Animal {
	BufferedImage image;
	private boolean drag = false;
	
	public LittleFish(int frameWidth, int frameHeight) throws IOException {
		super(frameWidth, frameHeight);
		xloc = (int)(frameWidth/12);
		yloc = (int)(frameHeight - (frameHeight/3));
		imageWidth = (int)(frameWidth/52);
		imageHeight = (int)(frameWidth/52);
		File file = new File("Fish_east_1.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}
	
	public String toString() {
		return "little fish";
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub
		
	}
	public boolean getDrag() {
		return drag;
	}
	public void setDrag(boolean d) {
		drag = d;
	}
}
