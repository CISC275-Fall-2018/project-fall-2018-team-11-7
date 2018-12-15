package Model;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import GameObjects.Camera;
import GameObjects.GameObjects;
import GameObjects.Animal;

public class Model implements java.io.Serializable{
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

	public void takePicture() {//
		// TODO Auto-generated method stub

	}

	public void addAnimals() throws IOException {} //

	public Camera getCamera() {//
		// TODO Auto-generated method stub
		return null;
	}

	public void update(){}//

	public void updateAnimals() {//
		// TODO Auto-generated method stub

	}

	public ArrayList<GameObjects> getObjects() {//
		// TODO Auto-generated method stub
		return null;
	}

	public int getScore() {//
		// TODO Auto-generated method stub
		return score;
	}

	public Animal getTarget() {//
		// TODO Auto-generated method stub
		return null;
	}

	public void update(int qChoice) {//
		// TODO Auto-generated method stub

	}

	public int getNum() {//
		// TODO Auto-generated method stub
		return (Integer) null;
	}

	public void drop(int x, int y) throws IOException {//
		// TODO Auto-generated method stub

	}

	public void update(int x, int y, boolean mouseloc, boolean next) throws IOException {//
		// TODO Auto-generated method stub

	}

	public String getFact() {//
		// TODO Auto-generated method stub
		return null;
	}

	public int getTime(){return 0;};//


	//Tried implementing serializable but ran into trouble because BufferedImages
	// cannot be serialized and all of our objects have their own bufferedimage
	// as a local variable and we tried handling this by giving them their own
	// writeObject methods which do not write the image and that should have fixed
	// the error but it doesnt
	public void save(){
		try{
			FileOutputStream fileOut = new FileOutputStream ("model.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException i){
			i.printStackTrace();
		}
	}

	public void load(){
		try{
			Model m = null;
			FileInputStream fileIn = new FileInputStream ("model.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			m = (Model) in.readObject();
			this.camera = m.camera;
			this.resetQChoice = m.resetQChoice;
			this.tutorial = m.tutorial;
			this.score = m.score;
			in.close();
			fileIn.close();
		} catch (IOException i){
			i.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
