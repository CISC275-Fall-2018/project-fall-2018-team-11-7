package Model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import GameObjects.Algae;
import GameObjects.BigFish;
import GameObjects.GameObjects;
import GameObjects.Crab;

public class ModelGame2 extends Model {
	ArrayList<GameObjects> objects = new ArrayList<GameObjects>();
	int algae=0;
	int crab=0;
	int bigFish=0;
	boolean next = false;
	int dayNum = 0;
	// score;

/**
 *  Model constructor for game 2, used to set proper coordinates based
	* on the frameWidth and frameHeight of the screen
 * @param width int, width of screen
 * @param height int, height of screen
 * @throws IOException
 */
	public ModelGame2(int width, int height) throws IOException {
		super(width, height);
		objects.add(new Algae(frameWidth, frameHeight));
		objects.add(new Crab(frameWidth, frameHeight));
		objects.add(new BigFish(frameWidth, frameHeight));
		this.tutorial = true;
		this.score = 0;
	}
	/**
	 * keeps track of animals on in the ecosystem
	 */
	public void count() {
		algae = -1;
		crab = -1;
		bigFish = -1;
		for(GameObjects o: objects) {
			switch(o.toString()) {
			case "algae":
				algae +=1;
				break;
			case "crab":
				crab +=1;
				break;
			case "big fish":
				bigFish +=1;
				break;
			}
		}
	}
	/**
	 * changes the number of animals and day number 
	 * @throws IOException
	 */
	public void run() throws IOException {
		count();
		//System.out.println(algae);
		ArrayList<GameObjects> fish = new ArrayList<GameObjects>();
		int b = bigFish;
		int c = crab;
		int a = algae;
		// for big fish
		if(b>=c) {
			bigFish = c;

			crab = 0;
		}
		else {
			bigFish = b;
			if(bigFish > 8) {
				bigFish = 8;
			}
		}
		if(c>=a) {
			if(a-b > 0) {
				crab = a-b;
			}
			else {
				crab = 0;
			}
			algae = 0;
		}
		else {
			if(b>=c) {
				crab=0;
			}
			else {
				crab = c - (((int)(b/2))+1) + ((int)(((c - (((int)(b/2))+1))/4))) - ((int)((((int)(bigFish/2))/2)));
				if(crab > 10) {
					crab = 10;
				}
			}
			if(a==0) {
				algae = 0;
			}
			else {
				algae = a - (((int)(c/2))+1) + ((int)(((a - (((int)(c/2))+1))/4))) - ((int)((((int)(crab/2))/2)));
				if(algae > 15) {
					algae = 15;
				}
			}
		}
		addAnimals();
		dayNum+=1;
		int cb = (crab - bigFish);
		if(cb>0) {
			score += cb;
		}
		int ac = (algae - crab);
		if(ac > 0) {
			score += ac;
		}
		tutorial = false;
	}
	/**
	 * adds the correct animals to the object list 
	 */
	public void addAnimals() throws IOException {
		int b = 0;
		int c = 0;
		int a = 0;
		ArrayList<GameObjects> animals = new ArrayList<GameObjects>();
		Random rand = new Random();
		while(b<bigFish) {
			animals.add(new BigFish(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth/2))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			b+=1;
		}
		while(c<crab) {
			animals.add(new Crab(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			c+=1;
		}
		while(a<algae) {
			animals.add(new Algae(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			a+=1;
		}

		animals.add(new BigFish(frameWidth, frameHeight));
		animals.add(new Crab(frameWidth, frameHeight));
		animals.add(new Algae(frameWidth, frameHeight));

		this.objects = animals;
	}
	/**
	 * updates the position of objects, and checks whether to go to the next day
	 * @param x int, new position for dragged object
	 * @param y int, new position for dragged object
	 * @param mouseloc boolean, whether the mouse location is being kept track of
	 * @param next boolean, whether to go to the next day
	 */
	@Override
	public void update(int x, int y, boolean mouseloc, boolean next) throws IOException {
		if(dayNum < 3) {
			if(mouseloc) {
				for(GameObjects o: objects) {
					if(o.getDrag()) {
						o.updatePosition(x,y);
					}
				}
			}
		}
		if(next) {
			run();
		}
	}
	/**
	 * determines where to drop an object, and update number of animals in
	 * the ecosystem
	 * @param x int, new location of dropped object
	 * @param y int, new location of dropped object
	 */
	@Override
	public void drop(int x, int y) throws IOException {
		ArrayList<GameObjects> newList = new ArrayList<GameObjects>();
		for(GameObjects o: objects) {
			if(o.getDrag()) {
				o.updatePosition(x,y);
				switch(o.toString()) {
				case "algae":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						if(o.getOrigin()) {
							newList.add(new Algae(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						if(o.getOrigin()) {
							newList.add(new Algae(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						newList.add(o);
						if(o.getOrigin()) {
							newList.add(new Algae(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					break;
				case "crab":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						if(o.getOrigin()) {
							newList.add(new Crab(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						if(o.getOrigin()) {
							newList.add(new Crab(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						newList.add(o);
						if(o.getOrigin()) {
							newList.add(new Crab(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					break;
				case "big fish":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						if(o.getOrigin()) {
							newList.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						if(o.getOrigin()) {
							newList.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						newList.add(o);
						if(o.getOrigin()) {
							newList.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					break;
				}
				o.setDrag(false);
			}
			else {
				newList.add(o);
			}

		}
		objects=newList;
	}
	/**
	 * returns object list
	 * @return objects ArrayList<GameObjects>, object list
	 */
	@Override
	public ArrayList<GameObjects> getObjects(){
		return objects;
	}
	/**
	 * returns day number
	 * @return dayNum int, day number
	 */
	@Override
	public int getNum() {
		return dayNum;
	}
	/**
	 * checks the number of a particular animal
	 * @param index int, which animal to check on
	 * @return number of specific type of animal in ecosystem
	 */
	public int getAnimalNums(int index) {
		int[] arr = {algae, crab, bigFish};
		return arr[index];
	}
	/**
	 * sets the number of particular animal
	 * @param algae int, number of algae
	 * @param crab int, number of crabs
	 * @param bigFish int, number of bigFish
	 */
	public void setAnimalNums(int algae, int crab, int bigFish) {
		this.algae = algae;
		this.crab = crab;
		this.bigFish = bigFish;
		//System.out.println(algae);
	}
}
