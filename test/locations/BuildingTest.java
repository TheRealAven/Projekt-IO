package locations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuildingTest {

    @Test
    public void obliczMocOświetlenia() {
        Building testBuilding = new Building(23);
        Floor testFloor1 = new Floor(33);
        testFloor1.addRoom(new Room(1, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor1);
        assertEquals(1.0, testBuilding.countLightningPower(), 0.0);

        Floor testFloor2 = new Floor(34);
        testFloor2.addRoom(new Room(2, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor2);
        assertEquals(1.0, testBuilding.countLightningPower(), 0.0);

        Floor testFloor3 = new Floor(35);
        testFloor3.addRoom(new Room(3, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor3);
        assertEquals(1.0, testBuilding.countLightningPower(), 0.0);
    }

    @Test
    public void obliczPowierzchnię() {
        Building testBuilding = new Building(23);
        Floor testFloor1 = new Floor(33);
        testFloor1.addRoom(new Room(1, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor1);
        assertEquals(10.0, testBuilding.countTotalArea(), 0.0);

        Floor testFloor2 = new Floor(34);
        testFloor2.addRoom(new Room(2, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor2);
        assertEquals(20.0, testBuilding.countTotalArea(), 0.0);

        Floor testFloor3 = new Floor(35);
        testFloor3.addRoom(new Room(3, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor3);
        assertEquals(30.0, testBuilding.countTotalArea(), 0.0);
    }

    @Test
    public void obliczKubaturę() {
        Building testBuilding = new Building(23);
        Floor testFloor1 = new Floor(33);
        testFloor1.addRoom(new Room(1, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor1);
        assertEquals(10.0, testBuilding.countTotalCubage(), 0.0);

        Floor testFloor2 = new Floor(34);
        testFloor2.addRoom(new Room(2, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor2);
        assertEquals(20.0, testBuilding.countTotalCubage(), 0.0);

        Floor testFloor3 = new Floor(35);
        testFloor3.addRoom(new Room(3, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor3);
        assertEquals(30.0, testBuilding.countTotalCubage(), 0.0);
    }
}