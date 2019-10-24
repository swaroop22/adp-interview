import java.util.Objects;

public class Slot {

    private int slotNumber;
    private ParkingLotType parkingLotType;
    private int duration;

    public Slot(int slotNumber, ParkingLotType parkingLotType, int duration) {
        this.slotNumber = slotNumber;
        this.parkingLotType = parkingLotType;
        this.duration = duration;

    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingLotType getParkingLotType() {
        return parkingLotType;
    }

    public void setParkingLotType(ParkingLotType parkingLotType) {
        this.parkingLotType = parkingLotType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return getSlotNumber() == slot.getSlotNumber() &&
                getDuration() == slot.getDuration() &&
                getParkingLotType() == slot.getParkingLotType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSlotNumber(), getParkingLotType(), getDuration());
    }
}
