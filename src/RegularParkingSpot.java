// Concrete implementation of ParkingSpot for general use
public class RegularParkingSpot extends ParkingSpot {

    public RegularParkingSpot(String spotId, VehicleType spotType, boolean hasCharging, int floorNumber) {
        super(spotId, spotType, hasCharging, floorNumber);
    }
}