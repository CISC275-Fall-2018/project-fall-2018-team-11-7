
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ModelGame1 extends Model{

	Camera camera;
	List<Animal> animals;
	Tree tree;
	Animal target;
	private int score;


	public ModelGame1(int frameWidth,int frameHeight){
		super(frameWidth,frameHeight);
		camera = new Camera(100,160,0,0);
		animals = new ArrayList<Animal>();
		score = 0;
	}

	void addAnimals() throws IOException{
		animals.add(new Fish((int)(frameWidth-(frameWidth/10)),(int)(frameHeight-(frameHeight/5)),(frameWidth/28),(frameWidth/52),frameWidth/2 - frameWidth/5,0));
		animals.add(new Fish((int)(frameWidth/2 + (frameWidth/10)),(int)(frameHeight-(frameHeight/3)),(frameWidth/28),(frameWidth/52),frameWidth/2 - frameWidth/5,1));
		animals.add(new Bird((int)(frameWidth/10),(int)(frameHeight/10),(frameWidth/15),(frameWidth/25),frameWidth - frameWidth/5,1));
		animals.add(new Bird((int)(frameWidth - frameWidth/10),(int)(frameHeight/7),(frameWidth/28),(frameWidth/52),frameWidth - frameWidth/5,0));
		animals.add(new Frog((int)(frameWidth/10),(int)(frameHeight - frameHeight/5),(frameWidth/52),(frameWidth/52),frameWidth/2 - frameWidth/5,1));
		animals.add(new Frog((int)(frameWidth/2 - frameWidth/10),(int)(frameHeight - frameHeight/4),(frameWidth/52),(frameWidth/52),frameWidth/2 - frameWidth/5,0));
		tree = new Tree((int)(0),(int)(0),(int)(frameWidth/3),(int)(frameWidth/2.5));
		changeTarget();
		System.out.println(frameWidth);
		System.out.println(frameHeight);
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
		int tmp = score;
		for(Animal a: animals){
			if(a.toString().equals(target.toString())){
					score += camera.snap(a.getX(),a.getY(),a.getWidth(),a.getHeight());
			}
		}
		if(score > tmp){
			changeTarget();
		}
		//System.out.println(camera.getX());
		//System.out.println(camera.getY());
	}

	void changeTarget(){
		Random rand = new Random();
		int randanimal = rand.nextInt(animals.size());
		target = animals.get(randanimal);
	}

	public int getScore(){
		return score;
	}

	public Animal getTarget(){
		return target;
	}

	public List getAnimals(){
		return animals;
	}
	public Tree getTree() {
		return tree;
	}

	public Camera getCamera(){
		return camera;
	}
}