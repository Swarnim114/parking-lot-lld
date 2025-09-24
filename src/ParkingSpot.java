public abstract class ParkingSpot {
    private String spotId;
    private VehicleType spotType;
    private boolean isAvailable;
    private boolean hasCharging;
    private int floorNumber;

    public ParkingSpot(String spotId, VehicleType spotType, boolean hasCharging, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.hasCharging = hasCharging;
        this.floorNumber = floorNumber;
        this.isAvailable = true; // Initially available
    }

    public void occupy() {
        this.isAvailable = false;
    }

    public void vacate() {
        this.isAvailable = true;
    }

    // Getters
    public String getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean hasCharging() {
        return hasCharging;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    // Setters
    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setHasCharging(boolean hasCharging) {
        this.hasCharging = hasCharging;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", spotType=" + spotType +
                ", isAvailable=" + isAvailable +
                ", hasCharging=" + hasCharging +
                ", floorNumber=" + floorNumber +
                '}';
    }
}