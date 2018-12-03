import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.io.IOException;

import org.junit.Test;

public class MyTests {

    @Test
    public void taskCheckerTesting() throws IOException, AWTException {
    	///testing for ModelGame1
        ModelGame1 tester = new ModelGame1(500,300); // MyClass is tested

        // test getScore()
        tester.camera.xloc=250;
        tester.camera.yloc=150;
        assertEquals(0, tester.getScore());
        // test fish constructor and xloc fish
        tester.animals.add(new Fish(5,0,0,0,0,0));
        assertEquals(5, tester.animals.get(0).xloc);
        //test getTarget and toString fish
        tester.target = (Animal) tester.animals.get(0);
        assertEquals("Fish", tester.getTarget().toString());
        //test camera constructor and camera getHeight
        tester.camera = new Camera(100, 160, 440, 260);
        assertEquals(100, tester.getCamera().getHeight());
        //testing bird constructor, getObjects, and bird getY
        tester.animals.add(new Bird(0,6,0,0,20,1));
        assertEquals(6,(tester.getObjects().get(1)).getY());
        //testing addAnimals, all animal constructors and tree constructor,
        // frog toString
        tester.animals.remove(1);
        tester.animals.remove(0);
        tester.addAnimals();
        assertEquals("Frog",tester.animals.get(5).toString());
        //testing updateCamera and takePicture
        tester.animals.get(5).xloc = 1000;
        tester.animals.get(5).yloc = 800;
        tester.updateCamera(920,750);
        tester.target = tester.animals.get(5);
        tester.takePicture();
        assertEquals(1, tester.getScore());
        //testing updateAnimals
        tester.animals.get(0).dir = 0;
        tester.animals.get(0).xloc = 0;
        tester.updateAnimals();
        assertEquals(8, tester.animals.get(0).getX());
        
        ///Starting tests for viewgame1
        //testing constructor
        Dimension size = new Dimension(1900,1000);
        ViewGame1 tester1 = new ViewGame1(1900,1000, size, tester.camera, tester.getObjects());
        assertEquals(1900, tester1.frameWidth);
        //testing update. Retesting getters for ModelGame1
        tester1.update(tester.getCamera(), tester.getObjects(), tester.getScore(), tester.getTarget().toString());
        assertEquals(tester.getObjects(),tester1.objects);
        
        ///Starting tests for modelgame3
        //testing model constructor and tree toString
        ModelGame3 tester2 = new ModelGame3(1900,1000);
        assertEquals("Tree", tester2.getObjects().get(0).toString());
        //testing update and getScore
        tester2.questionNum = 1;
        tester2.update(1);
        assertEquals(1, tester2.getScore());
        //testing getQNum
        assertEquals(2, tester2.getQNum());
        
        //Starting tests for viewgame3 and animation3
        //testing veiwgame3 constructor and tree getWidth
        ViewGame3 tester3 = new ViewGame3(1900,1000,size,tester2.objects);
        assertEquals(633, tester3.objects.get(0).getWidth());
        //testing viewgame3 update, animation3 update, and animation3 constructor
        tester3.update(3, 2, 0);
        assertEquals(2, tester3.a.score);
        tester3.update(2,2,0);
        assertEquals(2, tester3.a.questionNum);
        //testing get qchoice
        tester3.qchoice = 3;
        assertEquals(3,tester3.getQChoice());
        
        //Starting tests for modelgame2
        //testing ModelGame2 constructor and run()
        ModelGame2 tester4 = new ModelGame2(1900,1000);
        tester4.bigFish = 3;
        tester4.middleFish = 7;
        tester4.littleFish = 15;
        tester4.run();
        assertEquals(4, tester4.bigFish);
        assertEquals(6, tester4.middleFish);
        assertEquals(15, tester4.littleFish);
        
    }
}