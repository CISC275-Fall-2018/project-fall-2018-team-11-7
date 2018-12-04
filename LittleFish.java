import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LittleFish extends Animal {
	BufferedImage image;
	private boolean drag = false;
	private boolean origin = true;
	
	public LittleFish(int frameWidth, int frameHeight) throws IOException {
		super(frameWidth, frameHeight);
		xloc = (int)(frameWidth/16);
		yloc = (int)(frameHeight - (frameHeight/4) - (frameHeight/20));
		imageWidth = (int)(frameWidth/52);
		imageHeight = (int)(frameWidth/52);
		File file = new File("Fish_east_1.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}
	
	public LittleFish(int frameWidth, int frameHeight, int xloc, int yloc) throws IOException {
		super(frameWidth, frameHeight);
		this.xloc = xloc;
		this.yloc = yloc;
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
	public boolean getOrigin() {
		return origin;
	}
	public void setOrigin(boolean o) {
		origin = o;
	}
}
