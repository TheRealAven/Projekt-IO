package locations;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlertEnergyConsumptionVisitorTest {

    @Test
    public void mockAlert(){
        Room mockRoom1 = mock(Room.class);
        when(mockRoom1.countEnergyConsumption()).thenReturn(6.0);
        AlertEnergyConsumptionVisitor visitor = new AlertEnergyConsumptionVisitor(5.5);
        visitor.visitRoom(mockRoom1);
        assertEquals(1.0, visitor.getRoomsExceedingEnergyConsumption().size(), 0.0);
    }

}