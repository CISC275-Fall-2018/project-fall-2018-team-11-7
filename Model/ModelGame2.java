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
	
	public ModelGame2(int width, int height) throws IOException {
		super(width, height);
		objects.add(new Algae(frameWidth, frameHeight));
		objects.add(new Crab(frameWidth, frameHeight));
		objects.add(new BigFish(frameWidth, frameHeight));
		this.tutorial = true;
		this.score = 0;
	}
	
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
		System.out.println(algae);
		System.out.println(crab);
		System.out.println(bigFish);
	}
	
	public void run() throws IOException {
		count();
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
		}
		b = 0;
		c = 0;
		a = 0;
		Random rand = new Random();
		while(b<bigFish) {
			fish.add(new BigFish(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth/2))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			b+=1;
		}
		while(c<crab) {
			fish.add(new Crab(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			c+=1;
		}
		while(a<algae) {
			fish.add(new Algae(frameWidth, frameHeight, (int)(frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (int)(frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/2)))));
			a+=1;
		}
		
		fish.add(new BigFish(frameWidth, frameHeight));
		fish.add(new Crab(frameWidth, frameHeight));
		fish.add(new Algae(frameWidth, frameHeight));
		
		this.objects = fish;
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
		System.out.println(objects.size());
	}
	@Override
	public ArrayList<GameObjects> getObjects(){
		return objects;
	}
	
	@Override 
	public int getNum() {
		return dayNum;
	}
	public int getAnimalNums(int index) {
		int[] arr = {algae, crab, bigFish};
		return arr[index];
	}
	public void setAnimalNums(int algae, int crab, int bigFish) {
		this.algae = algae;
		this.crab = crab;
		this.bigFish = bigFish;
	}
}
