
public abstract class ParkingSpot {
    private String spotId;
    private VehicleType spotType;
    private boolean isAvailable;
    private boolean hasCharging;
    private double baseRate;
    private int floorNumber;

    public ParkingSpot(String spotId, VehicleType spotType, boolean hasCharging, double baseRate, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
        this.hasCharging = hasCharging;
        this.baseRate = baseRate;
        this.floorNumber = floorNumber;
    }

    public boolean canParkVehicle(Vehicle vehicle) {
        return isAvailable && spotType == vehicle.getType();
    }

    public double calculateAdditionalCharges() {
        return hasCharging ? 10.0 : 0.0;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean hasCharging() {
        return hasCharging;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
