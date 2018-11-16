
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
/*
import java.util.ArrayList;

public class ModelGame1 extends Model{
	
	ArrayList<Animal> animals;
	Camera camera;
	String[] taskList = {"Take a picture of a mammal","Take a picture of a fish"};
	int taskNumber = 0;
	
	public ModelGame1(int width, int height) {
		super(width, height);
		animals.add(new Mammal(100,100,Direction.EAST));
		animals.add(new Fish(100,100, Direction.WEST));
		// TODO Auto-generated constructor stub
	}
	void update() {
		for(Animal element:animals) {
			element.updatePosition();
		}
		camera.updatePosition();
	}
	void takePicture() {
		switch(taskNumber) {
			case 0:
				for(Animal element:animals) {
					if(element instanceof Mammal) {
						if((element.getX() < (camera.getX() + (camera.height/2))) &&( element.getX() > (camera.getX() -(camera.height/2)))) {
							if((element.getY() < (camera.getY() + (camera.width/2))) &&( element.getY() > (camera.getY() -(camera.width/2)))) {
								taskCompleted();
							}
						}
					}
				}
			case 1:
				for(Animal element:animals) {
					if(element instanceof Fish) {
						if((element.getX() < (camera.getX() + (camera.height/2))) &&( element.getX() > (camera.getX() -(camera.height/2)))) {
							if((element.getY() < (camera.getY() + (camera.width/2))) &&( element.getY() > (camera.getY() -(camera.width/2)))) {
								taskCompleted();
							}
						}
					}
				}
		}
	}
	void taskCompleted() {
		if(taskNumber < taskList.length-1) {
			taskNumber+=1;
		}
		else {
			run=false;
		}
	}
	*/

}
