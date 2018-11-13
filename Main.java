
public class Main {
	public static void main(String[] args){
	    Controller c = new Controller(new ViewGame1(), new ModelGame1(500, 300));
	    c.start();
	}
}
