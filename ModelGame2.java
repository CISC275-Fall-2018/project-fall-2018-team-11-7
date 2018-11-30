import java.util.ArrayList;

public class ModelGame2 extends Model {
	ArrayList<GameObjects> objects;
	int prey=0;
	int mid=0;
	int predator=0;
	
	public ModelGame2(int width, int height) {
		super(width, height);
	}
	
	void addAnimal(String type) {
		switch(type) {
		case "prey":
			prey += 1;
		case "mid":
			mid +=1;
		case "predator":
			predator +=1;
		}
		
	}
	void removeAnimal() {}
	
	void run() {
		
	}
}
