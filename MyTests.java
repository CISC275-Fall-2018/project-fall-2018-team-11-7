import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MyTests {

    @Test
    public void taskCheckerTesting() throws IOException {
        ModelGame1 tester = new ModelGame1(500,300); // MyClass is tested

        // assert statements
        tester.camera.xloc=250;
        tester.camera.yloc=150;
        assertEquals(0, tester.getScore());
        tester.animals.add(new Fish(5,0,0,0,0,0));
        assertEquals(5, tester.animals.get(0).xloc);
        tester.target = (Animal) tester.animals.get(0);
        assertEquals("Fish", tester.getTarget().toString());
        tester.camera.xloc = 440;
        tester.camera.yloc = 260;
        assertEquals(100, tester.getCamera().height);
        tester.animals.add(new Bird(0,0,0,0,20,1));
        assertEquals("Bird",tester.getObjects().get(1).toString());
    }
}