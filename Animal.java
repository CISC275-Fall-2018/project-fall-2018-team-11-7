import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Animal {
	int xloc;
	int yloc;
	int xvel;
	int yvel;
	int imageWidth;
	int imageHeight;
	Direction d;
	int dir;
	public BufferedImage[] images = new BufferedImage[12];

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

	Direction getDirection() {
		return d;
	}
	void updatePosition() {
		switch (d.getName()) {
			case "north":
				yloc +=yvel;
			case "northeast":
				xloc+=xvel;
				yloc+=yvel;
			case "east":
				xloc+=xvel;
			case "southeast":
				xloc+=xvel;
				yloc-=yvel;
			case "south":
				yloc-=0;
			case "southwest":
				xloc-=xvel;
				yloc-=yvel;
			case "west":
				xloc -=xvel;
			case "northwest":
				xloc -= xvel;
				yloc +=yvel;
		}
	}
	public BufferedImage getImage(int i) {
		return images[i];
	}

	public int getDir() {
		return dir;
	}

	public abstract String toString();

}
