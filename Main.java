import java.io.IOException;

import Controller.Controller;

public class Main{
  public static void main(String[] args) throws IOException{
    Controller c = new Controller();
    c.start();
  }
/*
public class Main {
	public static void main(String[] args){
	    Controller c = new Controller(new ViewGame1(), new ModelGame1(500, 300));
	    c.start();
	}
  */
}
