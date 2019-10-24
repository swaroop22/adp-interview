import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotSystem {

    private List<Slot> slots;
    private boolean[] availableSlots;

    private BigDecimal revenue = BigDecimal.ZERO;
    private static final Long HOURLY_RATE = 2L;

    //Initializing Parking Lot with number of parking lots
    public LotSystem(int numberOfSlotsInParkingLot){
        slots = new ArrayList<>(numberOfSlotsInParkingLot);
        this.availableSlots = new boolean[numberOfSlotsInParkingLot];
        updateAvailableSlots(numberOfSlotsInParkingLot);
    }

    // All Slots are available when we create a parking lot
    private void updateAvailableSlots(int numberOfSlotsInParkingLot) {
        for (int i=0;i<numberOfSlotsInParkingLot;i++) {
            availableSlots[i] = true;
        }

    }

    /*
        parking a vehicle based on inputs slotNumber, LotType (STANDARD, HANDI_CAPPED) and duration
        removing slot from availableSots
        and
        adding it into occupied slots
        adding it to revenue based on duration
     */
    public void park(int slotNumber, ParkingLotType type, int duration){
        Slot slot = new Slot(slotNumber, type, duration);
        availableSlots[slotNumber-1] = false;
        slots.add(slot);
        revenue = revenue.add(BigDecimal.valueOf(HOURLY_RATE*duration));
    }

    // retrieving occupied slots from slots list in map Key as slotNumber and Value as LotType
    public Map<Integer, ParkingLotType>  getOccupiedSlots(){
        return this.slots.stream().collect(Collectors.toMap(Slot::getSlotNumber, Slot::getParkingLotType));
    }

    // traversing through all slots if is is not occupied adding it into list and returning available slots
    public List<Integer> getAvailableSlots(){
        List<Integer> availableSlotsList = new ArrayList<>();
        for(int i =0;i<availableSlots.length;i++) {
            if (availableSlots[i]) availableSlotsList.add(i+1);
        }
        return availableSlotsList;
    }

    // return revenue
   public BigDecimal getRevenue(){
        return revenue;
   }

}
