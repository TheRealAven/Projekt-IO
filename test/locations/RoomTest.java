package locations;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void countLightningPower() {
        Room testRoom1 = new Room(1, 10, 10, 10, 10);
        assertEquals(10.0, testRoom1.countLightningPower(), 0.0);

        Room testRoom2 = new Room(2, 20, 20, 20, 20);
        assertEquals(20.0, testRoom2.countLightningPower(), 0.0);

        Room testRoom3 = new Room(3, 30, 30, 30, 30);
        assertEquals(30.0, testRoom3.countLightningPower(), 0.0);
    }

    @Test
    public void countTotalArea() {
        Room testRoom1 = new Room(1, 10, 10, 10, 10);
        assertEquals(10.0, testRoom1.countTotalArea(), 0.0);

        Room testRoom2 = new Room(2, 20, 20, 20, 20);
        assertEquals(20.0, testRoom2.countTotalArea(), 0.0);

        Room testRoom3 = new Room(3, 30, 30, 30, 30);
        assertEquals(30.0, testRoom3.countTotalArea(), 0.0);
    }

    @Test
    public void countTotalCubage() {
        Room testRoom1 = new Room(1, 10, 10, 10, 10);
        assertEquals(10.0, testRoom1.countTotalCubage(), 0.0);

        Room testRoom2 = new Room(2, 20, 20, 20, 20);
        assertEquals(20.0, testRoom2.countTotalCubage(), 0.0);

        Room testRoom3 = new Room(3, 30, 30, 30, 30);
        assertEquals(30.0, testRoom3.countTotalCubage(), 0.0);
    }

    @Test
    public void countEnergyConsumption() {
        Room testRoom1 = new Room(1, 10, 10, 10, 10);
        assertEquals(1.0, testRoom1.countEnergyConsumption(), 0.0);

        Room testRoom2 = new Room(2, 20, 20, 20, 20);
        assertEquals(1.0, testRoom2.countEnergyConsumption(), 0.0);

        Room testRoom3 = new Room(3, 30, 30, 30, 30);
        assertEquals(1.0, testRoom3.countEnergyConsumption(), 0.0);
    }
}