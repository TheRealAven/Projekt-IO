package locations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class BuildingTest {

    @Test
    public void countLightningPower() {
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
    public void countTotalArea() {
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
    public void countTotalCubage() {
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

    @Test
    public void countEnergyConsumption() {
        Building testBuilding = new Building(23);
        Floor testFloor1 = new Floor(33);
        testFloor1.addRoom(new Room(1, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor1);
        assertEquals(1.0, testBuilding.countEnergyConsumption(), 0.0);

        Floor testFloor2 = new Floor(34);
        testFloor2.addRoom(new Room(2, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor2);
        assertEquals(1.0, testBuilding.countEnergyConsumption(), 0.0);

        Floor testFloor3 = new Floor(35);
        testFloor3.addRoom(new Room(3, 10, 10, 10, 10));
        testBuilding.addFloor(testFloor3);
        assertEquals(1.0, testBuilding.countEnergyConsumption(), 0.0);
    }

    @Test
    public void mockEnergyConsumption(){
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Floor testFloor = new Floor();
        testFloor.addRoom(mockRoom1);
        testFloor.addRoom(mockRoom2);
        Building testBuilding = new Building(42);
        testBuilding.addFloor(testFloor);
        testBuilding.countEnergyConsumption();
        verify(mockRoom1).countEnergyConsumption();
        verify(mockRoom2).countEnergyConsumption();
    }

    @Test
    public void mockRoomProperties(){
        Room mockRoom1 = mock(Room.class);
        Floor testFloor = new Floor();
        testFloor.addRoom(mockRoom1);
        Building testBuilding = new Building(42);
        testBuilding.addFloor(testFloor);
        testBuilding.countEnergyConsumption();
        testBuilding.countLightningPower();
        InOrder inOrder = inOrder(mockRoom1);
        inOrder.verify(mockRoom1).countEnergyConsumption();
        inOrder.verify(mockRoom1).countLightningPower();
        inOrder.verify(mockRoom1).countTotalArea();
    }

    @Test
    public void mockMultipleFloor(){
        Room mockRoom1 = mock(Room.class);
        Floor testFloor = new Floor();
        Floor testFloor2 = new Floor();
        testFloor.addRoom(mockRoom1);
        testFloor2.addRoom(mockRoom1);
        Building testBuilding = new Building(42);
        testBuilding.addFloor(testFloor);
        testBuilding.addFloor(testFloor2);
        testBuilding.countTotalCubage();
        verify(mockRoom1, times(2)).countTotalCubage();
    }
}