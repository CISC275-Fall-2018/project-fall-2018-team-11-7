import java.awt.image.BufferedImage;

public class Fish extends Animal{
	BufferedImage[] fishImages;

	private int dir;
	private int distance;
	private int start;
	private int vel = 8;
	public Fish(int xloc, int yloc, int imageWidth, int imageHeight, int distance, int dir){
		super(xloc,yloc,imageWidth,imageHeight);
		this.dir = dir;
		this.distance = distance;
		if(dir == 1){
			start = xloc;
		}
		else{
			start = xloc-distance;
		}
	}

	void updatePosition(){
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
}
