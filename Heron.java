import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Heron extends Animal {

	BufferedImage[][] images = new BufferedImage[2][12];
	//Direction d = Direction.EAST;
	private int dir;
	private int distance;
	private int start;
	private int count = 0;
	private int vel = 3;
	private int yvel = 0;
	int picNum;
	final static int imgWidth = 1024;
    final static int imgHeight = 1024;

	public Heron(int xloc, int yloc, int imageWidth, int imageHeight, int distance, int dir) throws IOException{
		super(xloc,yloc,imageWidth,imageHeight);
		this.dir = dir;
		this.distance = distance;
		fact = "Herons can be found in Delaware year round";

		// gets all images for Bird

		File file1 = new File("heronwalking_NW.png");
		File file2 = new File("heronwalking_NE.png");
		if(file1.exists() && file2.exists()) {
			BufferedImage image1 = ImageIO.read(file1);
			//images[0] = image1;
			BufferedImage image2 = ImageIO.read(file2);
			//images[1] = image2;
			for(int i=0; i<12;i++) {
				images[0][i] = image1.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
				images[1][i] = image2.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
			}
		}


		if(dir == 1){
			start = xloc;
		}
		else{
			start = xloc-distance;
		}
	}

	public void updatePosition(){
		picNum = (picNum + 1)%12;

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
		return images[dir][picNum];
	}



	public int getDir() {
		return dir;
	}

	public String toString(){
		return "Heron";
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
	public void setOrigin(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePosition(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}

