package Tests;
import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.io.IOException;

import org.junit.Test;

import GameObjects.Animal;
import GameObjects.Bird;
import GameObjects.Camera;
import GameObjects.Fish;
import Model.ModelGame1;
import Model.ModelGame2;
import Model.ModelGame3;
import View.ViewGame1;
import View.ViewGame3;

public class MyTests {

    @Test
    public void taskCheckerTesting() throws IOException, AWTException {
    	///testing for ModelGame1
    	int frameWidth = 500;
    	int frameHeight = 300;
        ModelGame1 tester = new ModelGame1(frameWidth,frameHeight); // MyClass is tested

        // test getScore()
        tester.getCamera().setX(250);
        tester.getCamera().setY(150);
        assertEquals(0, tester.getScore());
        // test fish constructor and xloc fish
        tester.addAnimals();
        assertEquals((int)(frameWidth-(frameWidth/10)), tester.getObjects().get(0).getX());
        //test getTarget and toString fish
        tester.setTarget((Animal) tester.getObjects().get(0));
        assertEquals("Fish", tester.getTarget().toString());
        //test camera constructor and camera getHeight;
        assertEquals(175, tester.getCamera().getHeight());
        //testing bird constructor, getObjects, and bird getY
        assertEquals((int)(frameHeight-(frameHeight/3)),(tester.getObjects().get(1)).getY());
        //testing addAnimals, all animal constructors and tree constructor,
        // frog toString
        assertEquals("Frog",tester.getObjects().get(5).toString());
        //testing updateCamera and takePicture
        tester.getObjects().get(5).setX(1000);
        tester.getObjects().get(5).setY(800);
        tester.updateCamera(1000,800);
        tester.setTarget((Animal)tester.getObjects().get(5));
        tester.takePicture();
        assertEquals(1, tester.getScore());
      //testing timer
        assertEquals(60,tester.getTime());
        //testing updateAnimals
        tester.getObjects().get(0).setX(0);
        tester.update();
        assertEquals(8, tester.getObjects().get(0).getX());
        
        
        ///Starting tests for viewgame1
        //testing constructor
        Dimension size = new Dimension(1900,1000);
        ViewGame1 tester1 = new ViewGame1(1900,1000, size, tester.getCamera(), tester.getObjects());
        assertEquals(1900, tester1.getWidth());
        //testing update. Retesting getters for ModelGame1
        tester1.update(tester.getCamera(), tester.getObjects(), tester.getScore(), tester.getTarget().toString(), false, "null", 0);
        assertEquals(tester.getObjects(),tester1.getObjects());
        
        
        ///Starting tests for modelgame3
        //testing model constructor and tree toString
        ModelGame3 tester2 = new ModelGame3(1900,1000);
        assertEquals("Tree", tester2.getObjects().get(0).toString());
        //testing update and getScore
        tester2.setNum(1);
        tester2.update(3);
        assertEquals(10, tester2.getScore());
        //testing getQNum
        assertEquals(2, tester2.getNum());
        
        //Starting tests for viewgame3 and animation3
        //testing veiwgame3 constructor and tree getWidth
        ViewGame3 tester3 = new ViewGame3(1900,1000,size,tester2.getObjects(), 0,0);
        assertEquals(633, tester3.getObjects().get(0).getWidth());
        //testing viewgame3 update, animation3 update, and animation3 constructor
        tester3.update(3, 2, 0, false);
        assertEquals(2, tester3.getAnimation().getScore());
        tester3.update(2,2,0, false);
        assertEquals(2, tester3.getAnimation().getNum());
        //testing get qchoice
        tester3.setQChoice(3);
        assertEquals(3,tester3.getQChoice());
        
       /* //Starting tests for modelgame2
        //testing ModelGame2 constructor and run()
        ModelGame2 tester4 = new ModelGame2(1900,1000);
        tester4.bigFish = 2;
        System.out.println(tester4.bigFish);
        tester4.middleFish =8;
        tester4.littleFish = 5;
        tester4.run();
        System.out.println(tester4.bigFish);
        assertEquals(2, tester4.bigFish);
        assertEquals(3, tester4.middleFish);
        assertEquals(5, tester4.littleFish);*/
        
    }
}