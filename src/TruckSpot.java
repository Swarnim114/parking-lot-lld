
public class TruckSpot extends ParkingSpot {
    public TruckSpot(String spotId, boolean hasCharging, double baseRate, int floorNumber) {
        super(spotId, VehicleType.TRUCK, hasCharging, baseRate, floorNumber);
    }
}
