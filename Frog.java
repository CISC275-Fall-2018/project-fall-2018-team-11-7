import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Frog extends Animal{
	BufferedImage[] images = new BufferedImage[2];
	//Direction d = Direction.EAST;
	private int dir;
	private int distance;
	private int start;
	private int count = 0;
	private int vel = 6;
	private int yvel = 6;

	public Frog(int xloc, int yloc, int imageWidth, int imageHeight, int distance, int dir) throws IOException{
		super(xloc,yloc,imageWidth,imageHeight);
		this.dir = dir;
		this.distance = distance;

		// gets all images for Frog

		File file1 = new File("Fish_west_1.png");
		File file2 = new File("Fish_east_1.png");
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

	void updatePosition(){
		count++;
		vel = 6;
		if(count%4 == 0){
			yvel *= -1;
			vel = 0;
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

	@Override
	public BufferedImage getImage() {
		return images[dir];
	}



	public int getDir() {
		return dir;
	}

	public String toString(){
		return "Frog";
	}
}
