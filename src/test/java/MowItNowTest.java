import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MowItNowTest {

    @Test
    void testReadMissingInputFile() {
        String path = "src/test/resources/missing.txt";
        assertThrows(IOException.class, ()-> new MowItNow(path));
    }

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
    }

    @Test
    void testReadFileFirstLineAndInitiatePelouse() throws IOException {
        String path = "src/test/resources/valid.txt";
        MowItNow mowItNow = new MowItNow(path);
        Pelouse pelouse = mowItNow.getPelouse();
        assertEquals(5, pelouse.getHeight());
        assertEquals(5, pelouse.getWidth());
    }

    @Test
    void testReadFileFirstLineWithSpaceAndInitiatePelouse() throws IOException {
        String path = "src/test/resources/valid-with-spaces.txt";
        MowItNow mowItNow = new MowItNow(path);
        Pelouse pelouse = mowItNow.getPelouse();
        assertEquals(6, pelouse.getHeight());
        assertEquals(5, pelouse.getWidth());
    }
}
