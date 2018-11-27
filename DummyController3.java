import java.io.IOException;

public class DummyController3 {
	ViewGame3 view;
	ModelGame3 model;
	boolean go = true;
	
	public DummyController3() throws IOException {
		view = new ViewGame3(1600,1000);
		model = new ModelGame3(1600,1000);
	}
	
	public void start() {
		while(go) {
			model.update(view.getQChoice());
			view.update(model.getQNum(), model.getScore(), model.resetQChoice);
			if(model.getQNum()==4) {
				go=false;
			}
		}
	}
}
