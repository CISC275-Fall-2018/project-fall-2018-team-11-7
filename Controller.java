import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;

public class Controller {
	ViewGame1 view;
	ModelGame1 model;
	boolean game1 = true;
	int mX;
	int mY;

	public Controller() {

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

	public void start(){
		while(game1){
			mX = (int)MouseInfo.getPointerInfo().getLocation().getX();
			mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
			model.getCamera().updatePosition(mX,mY);
			model.updateAnimals();

			view.update(model.getCamera(),model.getAnimals(),model.getScore());
			}
		}
}
