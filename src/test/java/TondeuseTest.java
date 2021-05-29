import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseTest {
    //MOVE TONDEUSE TEST
    @Test
    void testMoveNorthTondeuse() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(0L, 3L, "N");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("0 4 N", res);
    }

    @Test
    void testMoveNorthTondeuseOutOfBound() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(0L, 4L, "N");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("0 4 N", res);
    }

    @Test
    void testMoveSouthTondeuse() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(0L, 1L, "S");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("0 0 S", res);
    }

    @Test
    void testMoveSouthTondeuseOutOfBound() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(0L, 0L, "S");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("0 0 S", res);
    }

    @Test
    void testMoveEastTondeuse() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(3L, 1L, "E");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("4 1 E", res);
    }

    @Test
    void testMoveEastTondeuseOutOfBound() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(4L, 0L, "E");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("4 0 E", res);
    }

    @Test
    void testMoveWestTondeuse() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(3L, 1L, "W");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("2 1 W", res);
    }

    @Test
    void testMoveWestTondeuseOutOfBound() {
        Pelouse pelouse = new Pelouse(4L, 4L);
        Tondeuse tondeuse = new Tondeuse(0L, 0L, "W");
        tondeuse.setInstructions("A");
        String res = tondeuse.move(pelouse);
        assertEquals("0 0 W", res);
    }
}
