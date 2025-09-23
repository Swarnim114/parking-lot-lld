
public class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    private boolean isEV;

    public Vehicle(String licenseNumber, VehicleType type, boolean isEV) {
        this.licenseNumber = licenseNumber;
        this.type = type;
        this.isEV = isEV;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isEV() {
        return isEV;
    }
}
