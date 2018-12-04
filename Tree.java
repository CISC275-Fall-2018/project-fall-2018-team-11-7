import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tree implements GameObjects {
	BufferedImage[] image = new BufferedImage[1];
	int xloc;
	int yloc;
	int imageWidth;
	int imageHeight;
	
	public Tree(int xloc, int yloc, int imageWidth, int imageHeight) throws IOException {
		File file = new File("Tree.png");
		
		if(file.exists()) {
			image[0] = ImageIO.read(file);
		}
		this.xloc = xloc;
		this.yloc = yloc;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	
	public BufferedImage getImage() {
		return image[0];
	}
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
	}

	public int getWidth(){
		return this.imageWidth;
	}

	public int getHeight(){
		return this.imageHeight;
	}
	public void updatePosition() {}
	
	public String toString() {
		return "Tree";
	}
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.xloc = x;
	}
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.yloc = y;
	}

	@Override
	public boolean getDrag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDrag(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getOrigin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOrigin(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
