package GameObjects;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Algae extends Animal {
	BufferedImage image;
	private boolean drag = false;
	private boolean origin = true;

	public Algae(int frameWidth, int frameHeight) throws IOException {
		super(frameWidth, frameHeight);
		xloc = (int)(frameWidth/16);
		yloc = (int)(frameHeight - (frameHeight/4) - (frameHeight/20));
		imageWidth = (int)(frameWidth/40);
		imageHeight = (int)(frameWidth/40);
		File file = new File("images/algae.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}

	public Algae(int frameWidth, int frameHeight, int xloc, int yloc) throws IOException {
		super(frameWidth, frameHeight);
		this.xloc = xloc;
		this.yloc = yloc;
		imageWidth = (int)(frameWidth/40);
		imageHeight = (int)(frameWidth/40);
		File file = new File("images/algae.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}

	public String toString() {
		return "algae";
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public void updatePosition(int x, int y) {
		this.xloc = x - (int)(imageWidth/2 + imageWidth/4);
		this.yloc = y - (int)(2*imageHeight - imageHeight/25);
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

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}
}
