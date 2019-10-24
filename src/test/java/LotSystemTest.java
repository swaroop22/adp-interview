import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LotSystemTest {

    private LotSystem lotSystem;

    @Before
    public void init(){
        initLots();
    }

    private void initLots() {
        lotSystem = new LotSystem(10);
        lotSystem.park(1, ParkingLotType.STANDARD, 1);
        lotSystem.park(2, ParkingLotType.HANDI_CAPPED, 2);
        lotSystem.park(5, ParkingLotType.STANDARD, 1);
        lotSystem.park(8, ParkingLotType.STANDARD, 1);
        lotSystem.park(4, ParkingLotType.STANDARD, 1);
    }

    @Test
    public void testOccupiedSlots(){
        Map<Integer, ParkingLotType> occupiedSlots = lotSystem.getOccupiedSlots();
        assertEquals(5, occupiedSlots.size());
    }

    @Test
    public void testRevenue(){
        assertEquals(BigDecimal.valueOf(12), lotSystem.getRevenue());
    }

    @Test
    public void testAvailableSlots(){
        List<Integer> availableSlots = lotSystem.getAvailableSlots();
        assertEquals(5, availableSlots.size());
    }

}
