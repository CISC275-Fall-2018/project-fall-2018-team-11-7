
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

	int getWidth(){
		return width;
	}

	int getHeight(){
		return height;
	}

	int getX() {
		return xloc;
	}

	int getY(){

		return yloc;
	}

	void updatePosition(int xloc, int yloc) {
		this.xloc = xloc;
		this.yloc = yloc;
	}

	int snap(int x, int y, int xlen, int ylen){
		if(x>xloc && x+xlen < xloc+width && y>yloc && y+ylen < yloc+height){
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
