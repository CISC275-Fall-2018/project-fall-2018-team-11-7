package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.io.IOException;

import GameObjects.GameObjects;
import Model.Model;
import Model.ModelGame1;
import Model.ModelGame2;
import Model.ModelGame3;
import View.View;
import View.ViewGame1;
import View.ViewGame2;
import View.ViewGame3;

public class Controller {
	View view;
	Model model;
	boolean game1 = true;
	boolean game2 = true;
	boolean game3 = true;
	int mX;
	int mY;
	boolean dragging = false;
	boolean mouseloc = false;
	static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	protected static int frameWidth = (int) size.getWidth();
	protected static int frameHeight = (int) size.getHeight();
	int score1;
	int score2;
	//int score3;

	public Controller() throws IOException {

		MouseListener mouseinput = new MouseListener(){
			public void mouseClicked(MouseEvent event){}
			public void mousePressed(MouseEvent event){}
			public void mouseReleased(MouseEvent event){
				model.takePicture();
			}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event){}
		};
		KeyListener keyinput = new KeyListener(){

			public void keyPressed(KeyEvent event){}
			public void keyReleased(KeyEvent event){
				if(event.getKeyCode() == KeyEvent.VK_S){
					model.save();

				}
				else if(event.getKeyCode() == KeyEvent.VK_L){
					model.load();
				}
			}
			public void keyTyped(KeyEvent event){}
		};



		model = new ModelGame1(frameWidth,frameHeight);
		model.addAnimals();
		view = new ViewGame1(frameWidth, frameHeight, size, model.getCamera(), model.getObjects());
		view.addMouseListener(mouseinput);
		view.addKeyListener(keyinput);
		view.requestFocusInWindow();
	}

	public void mouseLocation() {
		mX = (int)MouseInfo.getPointerInfo().getLocation().getX();
		mY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	}


	public void start() throws IOException{
		while(game1){
			mouseLocation();
			((ModelGame1)model).getCamera().updatePosition(mX,mY);
			model.update();

			view.update(model.getCamera(), model.getObjects(),model.getScore(),model.getTarget(), model.tutorial, model.getFact(),model.getTime());
			if(model.getTime()<0) {
				game1=false;
				score1 = (model.getScore());
			}
		}

		MouseListener mouseinput2 = getMouse2();

		model = new ModelGame2(frameWidth, frameHeight);
		view = new ViewGame2(frameWidth, frameHeight, size, model.getObjects(), mouseinput2);
		//view.addMouseListener(mouseinput2);

		while(game2) {
			mouseLocation();
			mouseloc = true;
			model.update(mX, mY, mouseloc, view.getNext());
			if(view.getNext()) {
				view.setNext(false);
			}
			view.update(model.getObjects(), model.tutorial, model.getScore(), model.getNum());
			if(model.getNum() >= 4) {
				game2 = false;
				score2 = model.getScore();
			}
		}

		model = new ModelGame3(frameWidth,frameHeight);
		view = new ViewGame3(frameWidth,frameHeight, size, model.getObjects(), score1, score2);

		while(game3) {
			model.update(view.getQChoice());
			view.update(model.getNum(), model.getScore(), model.resetQChoice, model.tutorial);
			if(model.getNum()==6) {
				game3=false;
			}
		}
	}

	public MouseListener getMouse2(){
		return new MouseListener() {
			public void mouseClicked(MouseEvent event){}
			public void mousePressed(MouseEvent event){}
			public void mouseReleased(MouseEvent event){
				if(dragging){
					mouseloc = false;
					dragging = false;
					try {
						model.drop(mX,mY);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					if(mX<frameWidth/7 && mY>(frameHeight/6)){
						for(GameObjects o: model.getObjects()) {
							if(o.getX() < frameWidth/7){
								//System.out.println("abs" + Math.abs(o.getY()-mY));
								//System.out.println("bound" + (frameHeight/3 - frameHeight/9)/4);
								if(Math.abs((o.getY() + o.getWidth()/2)+50-mY) <= (frameHeight/3 - frameHeight/9)/3){
									o.setX(mX);
									o.setY(mY);
									o.setDrag(true);
									dragging = true;
								}
							}
						}

					}
					else{
						mouseloc = true;
						for(GameObjects o: model.getObjects()) {
							if(mX>o.getX() && mX<(o.getX()+o.getWidth())) {
								if(mY>(o.getY()-100) && mY<(o.getY()+o.getHeight()+100)) {
									o.setX(mX);
									o.setY(mY);
									o.setDrag(true);
									dragging = true;
								}
							}
						}
					}
				}
			}
			public void mouseEntered(MouseEvent event){}
			public void mouseExited(MouseEvent event){}
		};
	}
}
