
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
}
