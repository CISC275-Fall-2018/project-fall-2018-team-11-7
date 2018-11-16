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
