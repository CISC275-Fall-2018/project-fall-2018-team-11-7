package GameObjects;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Animal implements GameObjects {
	protected int xloc;
	protected int yloc;
	protected int xvel;
	protected int yvel;
	protected int imageWidth;
	protected int imageHeight;
	protected int frameWidth;
	protected int frameHeight;
	int dir;
	String fact;
	protected BufferedImage[] images = new BufferedImage[2];
	
	public Animal(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
	}

	public Animal(int xloc,int yloc,int imageWidth,int imageHeight){
		this.xloc = xloc;
		this.yloc = yloc;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
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

	public int getDir() {
		return dir;
	}

	public abstract String toString();
	
	public void setX(int x) {
		this.xloc = x;
	}
	
	public void setY(int y) {
		this.yloc = y;
	}
	public String getFact() {
		return fact;
	}

}
