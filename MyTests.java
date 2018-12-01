import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MyTests {

    @Test
    public void taskCheckerTesting() throws IOException {
    	///testing for ModelGame1
        ModelGame1 tester = new ModelGame1(500,300); // MyClass is tested

        // assert statements
        tester.camera.xloc=250;
        tester.camera.yloc=150;
        assertEquals(0, tester.getScore());
        tester.animals.add(new Fish(5,0,0,0,0,0));
        assertEquals(5, tester.animals.get(0).xloc);
        tester.target = (Animal) tester.animals.get(0);
        assertEquals("Fish", tester.getTarget().toString());
        tester.camera = new Camera(100, 160, 440, 260);
        assertEquals(100, tester.getCamera().getHeight());
        tester.animals.add(new Bird(0,6,0,0,20,1));
        assertEquals(6,(tester.getObjects().get(1)).getY());
        tester.animals.remove(1);
        tester.animals.remove(0);
        tester.addAnimals();
        assertEquals("Frog",tester.animals.get(5).toString());
        tester.animals.get(5).xloc = 1000;
        tester.animals.get(5).yloc = 800;
        tester.updateCamera(920,750);
        tester.target = tester.animals.get(5);
        tester.takePicture();
        assertEquals(1, tester.getScore());
        tester.animals.get(0).dir = 0;
        tester.animals.get(0).xloc = 0;
        tester.updateAnimals();
        assertEquals(8, tester.animals.get(0).getX());
    }
}