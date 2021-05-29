import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MowItNowTest {

    //READING FILE TEST
    @Test
    void testReadMissingInputFile() {
        String path = "src/test/resources/missing.txt";
        assertThrows(IOException.class, ()-> new MowItNow(path));
    }

    //INITIATE PELOUSE TEST
    @Test
    void testFailToInitiatePelouseFromInputFile() {
        String path1 = "src/test/resources/empty-first-line.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path1));

        String path2 = "src/test/resources/invalid-first-line-1.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path2));

        String path3 = "src/test/resources/invalid-first-line-2.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path3));

        String path4 = "src/test/resources/invalid-first-line-3.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path4));

        String path5 = "src/test/resources/invalid-first-line-4.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path5));

        String path6 = "src/test/resources/invalid-first-line-5.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path6));
    }

    @Test
    void testInitiatePelouse() throws IOException {
        String path = "src/test/resources/valid.txt";
        MowItNow mowItNow = new MowItNow(path);
        Pelouse pelouse = mowItNow.getPelouse();
        assertEquals(5, pelouse.getHeight());
        assertEquals(5, pelouse.getWidth());
    }

    @Test
    void testInitiatePelouseWithSpacesInFirstLine() throws IOException {
        String path = "src/test/resources/valid-with-spaces.txt";
        MowItNow mowItNow = new MowItNow(path);
        Pelouse pelouse = mowItNow.getPelouse();
        assertEquals(6, pelouse.getHeight());
        assertEquals(5, pelouse.getWidth());
    }

    //INITIATE TONDEUSE TEST
    @Test
    void testFailToInitiateTondeuses() throws IOException {
        String path = "src/test/resources/invalid-tondeuse-1.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path));

        String path2 = "src/test/resources/invalid-tondeuse-2.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path2));

        String path3 = "src/test/resources/invalid-tondeuse-3.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path3));

        String path4 = "src/test/resources/invalid-tondeuse-4.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path4));

        String path5 = "src/test/resources/invalid-tondeuse-5.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path5));

        String path6 = "src/test/resources/invalid-tondeuse-instructions.txt";
        assertThrows(IllegalArgumentException.class, ()-> new MowItNow(path6));
    }

    @Test
    void testInitiateTondeuses() throws IOException {
        String path = "src/test/resources/valid.txt";
        MowItNow mowItNow = new MowItNow(path);
        List<Tondeuse> tondeuses = mowItNow.getTondeuses();
        assertEquals(2, tondeuses.size());
        Tondeuse tondeuse1 = tondeuses.get(0);
        assertEquals(1, tondeuse1.getPositionX());
        assertEquals(2, tondeuse1.getPositionY());
        assertEquals("N", tondeuse1.getDirection());
        assertEquals("GAGAGAGAA", tondeuse1.getInstructions());

        Tondeuse tondeuse2 = tondeuses.get(1);
        assertEquals(3, tondeuse2.getPositionX());
        assertEquals(3, tondeuse2.getPositionY());
        assertEquals("E", tondeuse2.getDirection());
        assertEquals("AADAADADDA", tondeuse2.getInstructions());
    }
}
