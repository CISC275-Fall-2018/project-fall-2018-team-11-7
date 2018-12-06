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
	boolean dragging = false;
	boolean mouseloc = false;
	static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	protected static int frameWidth = (int) size.getWidth();
	protected static int frameHeight = (int) size.getHeight();

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

		model = new ModelGame1(frameWidth,frameHeight);
		model.addAnimals();
		view = new ViewGame1(frameWidth, frameHeight, size, model.camera, model.getObjects());
		view.addMouseListener(mouseinput);
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

			view.update(model.getCamera(), model.getObjects(),model.getScore(),model.getTarget().toString(), model.tutorial, model.getFact());
			if(model.getScore()>=4) {
				game1=false;
			}
		}
		MouseListener mouseinput2 = new MouseListener() {
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
								if(Math.abs(o.getY()+50-mY) <= (frameHeight/3 - frameHeight/9)/3){
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
								if(mY>(o.getY()+50) && mY<(o.getY()+o.getHeight()+50)) {
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
			}
		}

		model = new ModelGame3(frameWidth,frameHeight);
		view = new ViewGame3(frameWidth,frameHeight, size, model.getObjects());

		while(game3) {
			model.update(view.getQChoice());
			view.update(model.getNum(), model.getScore(), model.resetQChoice, model.tutorial);
			if(model.getNum()==5) {
				game3=false;
			}
		}
	}
}