
public class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId, boolean hasCharging, double baseRate, int floorNumber) {
        super(spotId, VehicleType.BIKE, hasCharging, baseRate, floorNumber);
    }
}
