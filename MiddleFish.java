import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MiddleFish extends Animal {
	BufferedImage image;
	private boolean drag = false;
	private boolean origin = true;

	public MiddleFish(int frameWidth, int frameHeight) throws IOException {
		super(frameWidth, frameHeight);
		xloc = (int)(frameWidth/18);
		yloc = (int)(frameHeight/2 - frameHeight/28);
		imageWidth = (int)(frameWidth/28);
		imageHeight = (int)(frameWidth/28);
		File file = new File("images/Fish_east_1.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}

	public MiddleFish(int frameWidth, int frameHeight, int xloc, int yloc) throws IOException {
		super(frameWidth, frameHeight);
		this.xloc = xloc;
		this.yloc = yloc;
		imageWidth = (int)(frameWidth/28);
		imageHeight = (int)(frameWidth/28);
		File file = new File("images/Fish_east_1.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}

	public String toString() {
		return "middle fish";
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public void updatePosition(int x, int y) {
		this.xloc = x - (int)(imageWidth/2 + imageWidth/4);
		this.yloc = y - (int)(imageHeight + imageHeight/2 + imageHeight/4);
	}

	@Override
	public boolean getDrag() {
		return drag;
	}

	@Override
	public void setDrag(boolean d) {
		drag = d;
	}

	@Override
	public boolean getOrigin() {
		return origin;
	}

	@Override
	public void setOrigin(boolean o) {
		origin = o;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}

}
