import java.io.IOException;
import java.util.ArrayList;

public class Model {
	int frameWidth;
	int frameHeight;
	Camera camera = null;
	public int resetQChoice;
	public boolean tutorial;
	int score;

	public Model(int frameWidth,int frameHeight){
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}

	public void takePicture() {
		// TODO Auto-generated method stub
		
	}

	public void addAnimals() throws IOException {}

	public Camera getCamera() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAnimals() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GameObjects> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	public Object getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(int qChoice) {
		// TODO Auto-generated method stub
		
	}

	public int getNum() {
		// TODO Auto-generated method stub
		return (Integer) null;
	}

	public void update(int mX, int mY) {
		// TODO Auto-generated method stub
		
	}


	public void drop(int x, int y) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void update(int x, int y, boolean mouseloc, boolean next) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
