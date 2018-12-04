import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ModelGame2 extends Model {
	ArrayList<GameObjects> objects = new ArrayList<GameObjects>();
	int littleFish=0;
	int middleFish=0;
	int bigFish=0;
	boolean next = false;
	int dayNum = 0;
	
	public ModelGame2(int width, int height) throws IOException {
		super(width, height);
		objects.add(new LittleFish(frameWidth, frameHeight));
		objects.add(new MiddleFish(frameWidth, frameHeight));
		objects.add(new BigFish(frameWidth, frameHeight));
	}
	
	void count() {
		littleFish = -1;
		middleFish = -1;
		bigFish = -1;
		for(GameObjects o: objects) {
			System.out.println("count");
			switch(o.toString()) {
			case "little fish":
				System.out.println("little");
				littleFish +=1;
				break;
			case "middle fish":
				System.out.println("middle");
				middleFish +=1;
				break;
			case "big fish":
				System.out.println("big");
				bigFish +=1;
				break;
			}	
		}
	}
	
	void run() throws IOException {
		System.out.println("run");
		count();
		ArrayList<GameObjects> fish = new ArrayList<GameObjects>();
		System.out.println(bigFish+" "+middleFish+" "+littleFish);
		int b = bigFish;
		int m = middleFish;
		int l = littleFish;
		// for big fish
		if(b>m) {
			bigFish = m;
		}
		else {
			bigFish = b;
		}
		if(m>l) {
			m = l-b;
			l = 0;
		}
		else {
			if(b>m) {
				m=0;
			}
			else {
				middleFish = m - (((int)(b/2))+1) + ((int)(((m - (((int)(b/2))+1))/4))) - ((int)((((int)(bigFish/2))/2)));
				littleFish = l - (((int)(m/2))+1) + ((int)(((l - (((int)(m/2))+1))/4))) - ((int)((((int)(middleFish/2))/2)));
			}
		}
		littleFish = l - (((int)(m/2))+1) + ((int)(((l - (((int)(m/2))+1))/4))) - ((int)((((int)(middleFish/2))/2)));
		System.out.println(bigFish+" "+middleFish+" "+littleFish);
		b = 0;
		m = 0;
		l = 0;
		Random rand = new Random();
		while(b<bigFish) {
			fish.add(new BigFish(frameWidth, frameHeight, (frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/3)))));
			b+=1;
		}
		while(m<middleFish) {
			fish.add(new MiddleFish(frameWidth, frameHeight, (frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/3)))));
			m+=1;
		}
		while(l<littleFish) {
			fish.add(new LittleFish(frameWidth, frameHeight, (frameWidth/6 + rand.nextInt((int)(frameWidth - frameWidth/3))), (frameHeight/4 + frameHeight/10 + rand.nextInt((int)(frameHeight - frameHeight/3)))));
			l+=1;
		}
		
		fish.add(new BigFish(frameWidth, frameHeight));
		fish.add(new MiddleFish(frameWidth, frameHeight));
		fish.add(new LittleFish(frameWidth, frameHeight));
		
		this.objects = fish;
		System.out.println(objects);
		dayNum+=1;
	}
	
	@Override
	public void update(int x, int y, boolean mouseloc, boolean next) throws IOException {
		if(mouseloc) {
			for(GameObjects o: objects) {
				if(o.getDrag()) {
					o.setX(x - (int)(o.getWidth()));
					o.setY(y - (int)(o.getHeight()));
				}
			}
		}
		if(next) {
			run();
		}
	}
	@Override
	public void drop(int x, int y) throws IOException {
		ArrayList<GameObjects> removeList = new ArrayList<GameObjects>();
		for(GameObjects o: objects) {
			if(o.getDrag()) {
				o.setX(x - (int)(o.getWidth()));
				o.setY(y - (int)(o.getHeight()));
				switch(o.toString()) {
				case "little fish":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new LittleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new LittleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						if(o.getOrigin()) {
							objects.add(new LittleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
				case "middle fish":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new MiddleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new MiddleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						if(o.getOrigin()) {
							objects.add(new MiddleFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
				case "big fish":
					if(o.getX() > (int)(frameWidth - frameWidth/5) && o.getY() > (int)(frameHeight - frameHeight/4)) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else if(o.getX()<((int)(frameWidth/7)) && (o.getY()>(int)(frameHeight/6) && o.getY()<(int)(frameHeight - frameHeight/6))) {
						removeList.add(o);
						if(o.getOrigin()) {
							objects.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
					else {
						if(o.getOrigin()) {
							objects.add(new BigFish(frameWidth, frameHeight));
							o.setOrigin(false);
						}
					}
				}
				o.setDrag(false);
			}
			objects.removeAll(removeList);
		}
	}
	@Override
	public ArrayList<GameObjects> getObjects(){
		return objects;
	}
	
	@Override 
	public int getNum() {
		return dayNum;
	}
}
