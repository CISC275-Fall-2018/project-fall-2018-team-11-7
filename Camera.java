
public class Camera {
	int width;
	int height;
	int xloc;
	int yloc;
	int xvel = 4;
	int yvel = 4;
	Direction d = Direction.NONE;
	
	public Camera(int w, int h) {
		width = w;
		height = h;
	}
	
	int getX() {
		return xloc;
	}
	int getY() {
		return yloc;
	}
	Direction getDirection() {
		return null;
	}
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
}
