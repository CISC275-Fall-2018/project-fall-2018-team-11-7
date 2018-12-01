import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Controller {
	View view;
	Model model;
	boolean game1 = true;
	boolean game2 = true;
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

		model = new ModelGame1(frameWidth,frameHeight);
		model.addAnimals();
		view = new ViewGame1(frameWidth, frameHeight, size, model.camera, model.getObjects());
		view.addMouseListener(mouseinput);
		
		
		MouseListener mouseinput2 = new MouseListener() {
			public void mouseClicked(MouseEvent event){}
			@Override
			public void mousePressed(MouseEvent event){
				
			}
			public void mouseReleased(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event){}
		};
	}
	
	public void mouseLocation() {
		mX = (int)MouseInfo.getPointerInfo().getLocation().getX();
		mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	}
	

	public void start() throws IOException{
		while(game1){
			mouseLocation();
			((ModelGame1)model).getCamera().updatePosition(mX,mY);
			model.updateAnimals();

			view.update(model.getCamera(), model.getObjects(),model.getScore(),model.getTarget().toString());
			if(model.getScore()==5) {
				game1=false;
			}
		}
		
		model = new ModelGame3(frameWidth,frameHeight);
		view = new ViewGame3(frameWidth,frameHeight, size, model.getObjects());
		
		while(game3) {
			model.update(view.getQChoice());
			view.update(model.getQNum(), model.getScore(), model.resetQChoice);
			if(model.getQNum()==4) {
				game3=false;
			}
		}
	}
}