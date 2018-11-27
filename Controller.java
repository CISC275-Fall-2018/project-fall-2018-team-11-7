import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Controller {
	ViewGame1 view;
	ModelGame1 model;
	boolean game1 = true;
	boolean game3 = true;
	int mX;
	int mY;
	static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	protected static int frameWidth = (int) size.getWidth();
	protected static int frameHeight = (int) size.getHeight();

	public Controller() throws IOException {

		MouseListener mouseinput = new MouseListener(){
		@Override
		public void mouseClicked(MouseEvent event){
			model.takePicture();
		}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		};

	view = new ViewGame1(frameWidth,frameHeight, size);
	view.addMouseListener(mouseinput);
	System.out.println(frameHeight);
	model = new ModelGame1(frameWidth,frameHeight);
	model.addAnimals();

/*
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import java.io.IOException;
public class Controller {
	ViewGame1 view;
	ModelGame1 model;
	boolean game1 = true;
	int mX;
	int mY;
	public Controller() throws IOException {
		MouseListener mouseinput = new MouseListener(){
		@Override
		public void mouseClicked(MouseEvent event){
			model.takePicture();
		}
		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		};
	view = new ViewGame1(800,500);
	view.addMouseListener(mouseinput);
	model = new ModelGame1(800,500);
	model.addAnimals();
/*
import java.util.ArrayList;
public class Controller {
	ArrayList<Animal> animals;
	View view;
	Model model;
	public Controller(View v, Model m) {
		view = v;
		model = m;
		KeyListener input = new KeyListener(){
			@Override
			public void keyPressed(KeyEvent event){
				if(model instanceof ModelGame1) {
					if(event.getKeyCode() == KeyEvent.VK_UP){
						System.out.println("up");
						((ModelGame1)model).camera.setDirection(Direction.NORTH);
					}
					else if(event.getKeyCode() == KeyEvent.VK_LEFT){
						System.out.println("left");
						((ModelGame1)model).camera.setDirection(Direction.WEST);
					}
					else if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("right");
						((ModelGame1)model).camera.setDirection(Direction.EAST);
					}
					else if(event.getKeyCode()== KeyEvent.VK_KP_DOWN) {
						System.out.println("down");
						((ModelGame1)model).camera.setDirection(Direction.SOUTH);
					}
					if(event.getKeyCode() == KeyEvent.VK_ENTER) {
						((ModelGame1) model).takePicture();
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent event) {
				if(model instanceof ModelGame1) {
					if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode()==KeyEvent.VK_LEFT || event.getKeyCode()==KeyEvent.VK_RIGHT || event.getKeyCode()==KeyEvent.VK_DOWN) {
						((ModelGame1)model).camera.setDirection(Direction.NONE);
					}
				}
			}
			@Override
			public void keyTyped(KeyEvent event){}
		};
		view = new View();
		model = new Model(view.getWidth(), view.getHeight());
	}
	void start() {
		while(model.run == true) {
			if(model instanceof ModelGame1)
			((ModelGame1)model).update();
			view.updateView();
		}
    */
	}

	public void start() throws IOException{
		while(game1){
			
			mX = (int)MouseInfo.getPointerInfo().getLocation().getX();
			mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
			model.getCamera().updatePosition(mX,mY);
			model.updateAnimals();
			//System.out.println("update from controller");

			view.update(model.getCamera(),model.getAnimals(), model.getTree(),model.getScore(),model.getTarget().toString());
			if(model.getScore()==5) {
				game1=false;
			}
		}
		ViewGame3 view3 = new ViewGame3(frameWidth,frameHeight, size);
		ModelGame3 model3 = new ModelGame3(frameWidth,frameHeight);
		while(game3) {
			model3.update(view3.getQChoice());
			view3.update(model3.getQNum(), model3.getScore(), model3.resetQChoice);
			if(model3.getQNum()==4) {
				game3=false;
			}
		}
	}
}