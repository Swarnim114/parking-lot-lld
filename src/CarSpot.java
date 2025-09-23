
public class CarSpot extends ParkingSpot {
    public CarSpot(String spotId, boolean hasCharging, double baseRate, int floorNumber) {
        super(spotId, VehicleType.CAR, hasCharging, baseRate, floorNumber);
    }
}
