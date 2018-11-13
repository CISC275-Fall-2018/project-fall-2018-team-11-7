
public abstract class Animal {
	int xloc;
	int yloc;
	int xvel;
	int yvel;
	int imageWidth;
	int imageHeight;
	Direction d;
	
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
	}
	Direction getDirection() {
		return d;
	}
	void updatePositions() {
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
