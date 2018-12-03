import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fish extends Animal{
	BufferedImage[] images = new BufferedImage[2];
	//Direction d = Direction.EAST;
	private int dir;
	private int distance;
	private int start;
	private int vel = 8;

	public Fish(int xloc, int yloc, int imageWidth, int imageHeight, int distance, int dir) throws IOException{
		super(xloc,yloc,imageWidth,imageHeight);
		//System.out.println(imageHeight);
		this.dir = dir;
		this.distance = distance;
		// gets all images for fish
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

	public void updatePosition(){
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

	}
	public BufferedImage getImage() {
		return images[dir];
	}


	public int getDir() {
		return dir;
	}

	public String toString(){
		return "Fish";
	}
}

