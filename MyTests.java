import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTests {

    @Test
    public void taskCheckerTesting() {
        ModelGame1 tester = new ModelGame1(500,300); // MyClass is tested

        // assert statements
        tester.camera.xloc=250;
        tester.camera.yloc=150;
        assertEquals("Mammal in picture", tester.takePicture());
        assertEquals("Fish not in picture", tester.takePicture());
        tester.camera.xloc = 440;
        tester.camera.yloc = 260;
        assertEquals("Fish in picture", tester.takePicture());
    }
}