package locations;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloorTest {

    @Test
    public void countLightningPower() {
        Floor testFloor = new Floor(23);
        testFloor.addRoom(new Room(1, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countLightningPower(), 0.0);

        testFloor.addRoom(new Room(2, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countLightningPower(), 0.0);

        testFloor.addRoom(new Room(3, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countLightningPower(), 0.0);
    }

    @Test
    public void countTotalArea() {
        Floor testFloor = new Floor(23);
        testFloor.addRoom(new Room(1, 10, 10, 10, 10));
        assertEquals(10.0, testFloor.countTotalArea(), 0.0);

        testFloor.addRoom(new Room(2, 10, 10, 10, 10));
        assertEquals(20.0, testFloor.countTotalArea(), 0.0);

        testFloor.addRoom(new Room(3, 10, 10, 10, 10));
        assertEquals(30.0, testFloor.countTotalArea(), 0.0);
    }

    @Test
    public void countTotalCubage() {
        Floor testFloor = new Floor(23);
        testFloor.addRoom(new Room(1, 10, 10, 10, 10));
        assertEquals(10.0, testFloor.countTotalCubage(), 0.0);

        testFloor.addRoom(new Room(2, 10, 10, 10, 10));
        assertEquals(20.0, testFloor.countTotalCubage(), 0.0);

        testFloor.addRoom(new Room(3, 10, 10, 10, 10));
        assertEquals(30.0, testFloor.countTotalCubage(), 0.0);
    }

    @Test
    public void countEnergyConsumption() {
        Floor testFloor = new Floor(23);
        testFloor.addRoom(new Room(1, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countEnergyConsumption(), 0.0);

        testFloor.addRoom(new Room(2, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countEnergyConsumption(), 0.0);

        testFloor.addRoom(new Room(3, 10, 10, 10, 10));
        assertEquals(1.0, testFloor.countEnergyConsumption(), 0.0);
    }
}