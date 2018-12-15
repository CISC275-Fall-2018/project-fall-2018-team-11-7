package GameObjects;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends Animal {
	BufferedImage[] images = new BufferedImage[2];
	//Direction d = Direction.EAST;
	private int dir;
	private int distance;
	private int start;
	private int count = 0;
	private int vel = 12;
	private int yvel = 4;

	public Bird(int xloc, int yloc, int imageWidth, int imageHeight, int distance, int dir) throws IOException{
		super(xloc,yloc,imageWidth,imageHeight);
		this.dir = dir;
		this.distance = distance;
		fact = "Shore Birds eat horseshoe crab eggs";

		// gets all images for Bird

		File file1 = new File("images/bird_west.png");
		File file2 = new File("images/bird_east.png");
		if(file1.exists() && file2.exists()) {
			BufferedImage image1 = ImageIO.read(file1);
			images[0] = image1;
			BufferedImage image2 = ImageIO.read(file2);
			images[1] = image2;
		}


		if(dir == 1){
			start = xloc;
		}
		else{
			start = xloc-distance;
		}
	}

	public void updatePosition(){
		count++;
		if(count%10 == 0){
			yvel *= -1;
		}


		if(dir == 1 && xloc < start+distance){
			xloc += vel;
		}
		else if(dir == 1){
			dir = 0;
			xloc -= vel;
		}
		else if(dir == 0 && xloc > start){
			xloc -= vel;
		}
		else{
			dir = 1;
			xloc+=vel;
		}
		yloc += yvel;
	}


	public BufferedImage getImage() {
		return images[dir];
	}

	public BufferedImage getTargetImage() {
		return images[0];
	}



	public int getDir() {
		return dir;
	}

	public String toString(){
		return "Bird";
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

	@Override
	public void updatePosition(int x, int y) {
		// TODO Auto-generated method stub

	}
}
