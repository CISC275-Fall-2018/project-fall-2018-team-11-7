import java.util.List;
import java.util.ArrayList;

public class ModelGame1 extends Model{

	Camera camera;
	List<Animal> animals;
	private int score;


	public ModelGame1(int frameWidth,int frameHeight){
		super(frameWidth,frameHeight);
		camera = new Camera(50,80,0,0);
		animals = new ArrayList<Animal>();
		score = 0;
	}

	void addAnimals(){
		animals.add(new Fish(450,350,30,15,300,1));
		animals.add(new Fish(750,450,30,15,200,0));
	}

	void updateAnimals(){
		for(Animal a : animals){
			a.updatePosition();
		}
	}

	void updateCamera(int x, int y){
		camera.updatePosition(x,y);
	}

	void takePicture(){
		for(Animal a: animals){
			score += camera.snap(a.getX(),a.getY(),a.getWidth(),a.getHeight());
		}
		System.out.println(camera.getX());
		System.out.println(camera.getY());
	}

	public int getScore(){
		return score;
	}

	public List getAnimals(){
		return animals;
	}

	public Camera getCamera(){
		return camera;
	}
}
