import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	}
}
