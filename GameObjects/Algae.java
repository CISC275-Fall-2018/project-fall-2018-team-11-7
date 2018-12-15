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

	/**
	 * Constructor for algae class. Keeps track of framewidth and framehieght
	 * to properly size and place objects on the current device screen
	 * @param frameWidth int, frameWidth of screen
	 * @param frameHeight int, frameHeight of screen
	 * @throws IOException
	 */
	public Algae(int frameWidth, int frameHeight) throws IOException {
		super(frameWidth, frameHeight);
		xloc = (int)(frameWidth/16);
		yloc = (int)(frameHeight - (frameHeight/4) - (frameHeight/20));
		imageWidth = (int)(frameWidth/40);
		imageHeight = (int)(frameWidth/40);
		File file = new File("algae.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}
	/**
	 * Second constructor for algae class. Keeps track of framewidth and framehieght
	 * to properly size objects for the current device screen, as well as a location
	 * that can be specified.
	 * @param frameWidth int, frameWidth of screen
	 * @param frameHeight int, frameHeight of screen
	 * @param xloc int, x coordinate of algae
	 * @param yloc int, y coordinate of algae
	 * @throws IOException
	 */
	public Algae(int frameWidth, int frameHeight, int xloc, int yloc) throws IOException {
		super(frameWidth, frameHeight);
		this.xloc = xloc;
		this.yloc = yloc;
		imageWidth = (int)(frameWidth/40);
		imageHeight = (int)(frameWidth/40);
		File file = new File("algae.png");
		if(file.exists()) {
			image = ImageIO.read(file);
		}
	}
	/**
	 * returns the name of the object
	 * @return "algae" String, name of the object
	 */
	public String toString() {
		return "algae";
	}
	
	@Override
	/**
	 * returns an image of algae
	 * @return image BufferedImage, image of algae.
	 */
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	/**
	 * Updates the position parameters of the algae
	 * @param x int, new x position
	 * @param y int, new y position
	 */
	@Override
	public void updatePosition(int x, int y) {
		this.xloc = x - (int)(imageWidth/2 + imageWidth/4);
		this.yloc = y - (int)(2*imageHeight - imageHeight/25);
	}
	/**
	 * returns whether the algae is currently being dragged
	 * @return drag boolean, whether the algae is being dragged
	 */
	public boolean getDrag() {
		return drag;
	}
	/**
	 * sets whether the algae is being dragged
	 * @param d boolean, if the algae is being dragged
	 */
	public void setDrag(boolean d) {
		drag = d;
	}
	/**
	 * indicates whether the object came from the tool bar
	 * @return origin boolean, if the algae came from the toolbar
	 */
	public boolean getOrigin() {
		return origin;
	}
	/**
	 * sets whether the object came from the toolbar
	 * @param o boolean, sets if the object came from the toolbar
	 */
	public void setOrigin(boolean o) {
		origin = o;
	}
	/**
	 *updates position of gameobjects 
	 */
	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}
}
