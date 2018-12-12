package GameObjects;

public class Camera {

	int height;
	int width;
	int xloc;
	int yloc;

	public Camera(int height, int width, int xloc, int yloc) {
		this.height= height;
		this.width = width;
		this.xloc = xloc;
		this.yloc = yloc;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public int getX() {
		return xloc;
	}

	public int getY(){

		return yloc;
	}

	public void updatePosition(int xloc, int yloc) {
		this.xloc = xloc - (int)(width/2);
		this.yloc = yloc - (int)(height/2);
	}

	public int snap(int x, int y){
		
		if(x>xloc && x < xloc+width && y>yloc && y < yloc+height){
			return 1;
		}
		return 0;
	}
/*
	void setDirection(Direction dir) {
		d = dir;
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
*/
}
