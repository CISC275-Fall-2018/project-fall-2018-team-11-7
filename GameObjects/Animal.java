package GameObjects;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class Animal implements GameObjects, java.io.Serializable {
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

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(xloc);
		out.writeInt(yloc);
		out.writeInt(xvel);
		out.writeInt(yvel);
		out.writeInt(imageWidth);
		out.writeInt(imageHeight);
		out.writeInt(frameWidth);
		out.writeInt(frameWidth);
		out.writeInt(dir);
		out.writeUTF(fact);
	}

	/**
	* Animal constructor, used to create animal with a specific
	* width and height. This constructor is used by all subclasses of Animals
	* which are created for Game 1.
	* @param frameWidth width of animal
	* @param frameHeight height of animal
	*/
	public Animal(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
	}

	/**
	* Second Animal constructor, used to create animal with an imageWidth, imageHeight
	* and starting x and y locations. Used by animal subclasses in Game 2.
	* @param xloc initial x location
	* @param yloc initial y location
	* @param imageWidth width of Animal's image
	* @param imageHeight height of Animal's image
	*/
	public Animal(int xloc,int yloc,int imageWidth,int imageHeight){
		this.xloc = xloc;
		this.yloc = yloc;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	/**
	* returns x location of Animal
	*/
	public int getX() {
		return xloc;
	}
	/**
	* returns y location of Animal
	*/
	public int getY() {
		return yloc;
	}
	/**
	* returns imageWidth of Animal
	*/
	public int getWidth(){
		return this.imageWidth;
	}
	/**
	* returns imageHeight of Animal
	*/
	public int getHeight(){
		return this.imageHeight;
	}

	public int getDir() {
		return dir;
	}


	public abstract String toString();
	/**
	* set x location of Animal
	* @param x integer used to set location
	*/
	public void setX(int x) {
		this.xloc = x;
	}
	/**
	* set y location of Animal
	* @param y integer used to set location
	*/
	public void setY(int y) {
		this.yloc = y;
	}
	/**
	* get Fact of Animal, used in Game1
	*/
	public String getFact() {
		return fact;
	}

	public BufferedImage getTargetImage() {
		return images[0];
	}

}
