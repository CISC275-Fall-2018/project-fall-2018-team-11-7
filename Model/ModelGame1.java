package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import GameObjects.Animal;
import GameObjects.Bird;
import GameObjects.Duck;
import GameObjects.Fish;
import GameObjects.Frog;
import GameObjects.GameObjects;
import GameObjects.Heron;
import GameObjects.Camera;
import GameObjects.Tree;

public class ModelGame1 extends Model{

	List<Animal> animals;
	Tree tree;
	Animal target;
	String fact = " ";
	ArrayList<String> prevAnimals = new ArrayList<String>();
	Random rand = new Random();
	int time;
	Timer timer;

	public ModelGame1(int frameWidth,int frameHeight){
		super(frameWidth,frameHeight);
		camera = new Camera(175,250,0,0);
		animals = new ArrayList<Animal>();
		score = 0;
		tutorial = true;
		time = 60;
		timer = new Timer();
	}
	@Override
	public void addAnimals() throws IOException{
		animals.add(new Fish((int)(frameWidth-(frameWidth/10)),(int)(frameHeight-(frameHeight/5)),(frameWidth/28),(frameWidth/42),frameWidth/2 - frameWidth/5,0));
		animals.add(new Fish((int)(frameWidth/2 + (frameWidth/10)),(int)(frameHeight-(frameHeight/3)),(frameWidth/28),(frameWidth/42),frameWidth/2 - frameWidth/5,1));
		animals.add(new Bird((int)(frameWidth/10),(int)(frameHeight/10),(frameWidth/20),(frameWidth/30),frameWidth - frameWidth/5,1));
		animals.add(new Bird((int)(frameWidth - frameWidth/10),(int)(frameHeight/7),(frameWidth/20),(frameWidth/30),frameWidth - frameWidth/5,0));
		animals.add(new Frog((int)(frameWidth/10),(int)(frameHeight - frameHeight/5),(frameWidth/52),(frameWidth/52),frameWidth/2 - frameWidth/5,1));
		animals.add(new Frog((int)(frameWidth/2 - frameWidth/10),(int)(frameHeight - frameHeight/4),(frameWidth/52),(frameWidth/52),frameWidth/2 - frameWidth/5,0));
		animals.add(new Heron((int)(frameWidth/2 - frameWidth/6),(int)(frameHeight/3),(frameWidth/4),(frameWidth/4),frameWidth/5,0));
		animals.add(new Duck((int)(frameWidth/2 + frameWidth/8),(int)(frameHeight/2 - frameHeight/25),(frameWidth/30),(frameWidth/30),(frameWidth/3 - frameWidth/6),1));
		tree = new Tree((int)(0),(int)(0),(int)(frameWidth/3),(int)(frameWidth/2.5));
		changeTarget();
	}

	public void update(){
		if(time>0){
			updateAnimals();
		}
		if(time == 0){
			timer.cancel();
		}
	}
	@Override
	public void updateAnimals(){
		if(!tutorial) {
			for(Animal a : animals){
				a.updatePosition();
			}
		}
	}

	public void updateCamera(int x, int y){
		camera.updatePosition(x,y);
	}
	@Override
	public void takePicture(){
		if(time > 0) {
			int tmp = score;
			for(Animal a: animals){
				if(a.toString().equals(target.toString())){
					score += camera.snap(a.getX() + (int)(a.getWidth()/2), a.getY() + (int)(a.getHeight()/2));
					if(score > tmp && prevAnimals.size()<5) {
						fact = a.getFact();
					}
				}
			}
			if(score > tmp){
				if(tutorial) {
					tutorial = false;
				}
				if(prevAnimals.size() < 6){
					prevAnimals.add(target.toString());
					if(prevAnimals.size() == 5){
						timer.schedule(new TimerTask(){
							public void run(){if(time>0){time--;}}},1000,1000);
					}
				}
				changeTarget();
			}
		}
		else{
			time--;
		}
		//System.out.println(camera.getX());
		//System.out.println(camera.getY());
	}

	void changeTarget(){
		int randanimal = rand.nextInt(animals.size());
		target = animals.get(randanimal);
		if(prevAnimals.size()<5) {
			for(String s: prevAnimals) {
				while(s.equals(target.toString())) {
					changeTarget();
				}
			}
		}
	}
	@Override
	public int getScore(){
		return score;
	}
	@Override
	public Animal getTarget(){
		return target;
	}
	public void setTarget(Animal a) {
		this.target = a;
	}
	@Override
	public ArrayList<GameObjects> getObjects(){
		ArrayList<GameObjects> objects = new ArrayList<GameObjects>();
		objects.addAll(animals);
		objects.add(tree);
		return objects;
	}
	@Override
	public Camera getCamera(){
		return camera;
	}
	@Override
	public String getFact() {
		return fact;
	}
	@Override
	public int getTime(){
		return time;
	}
	
}
