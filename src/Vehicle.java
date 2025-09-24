public class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    private boolean isEV;

    public Vehicle(String licenseNumber, VehicleType type, boolean isEV) {
        this.licenseNumber = licenseNumber;
        this.type = type;
        this.isEV = isEV;
    }

    // Getters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isEV() {
        return isEV;
    }

    // Setters
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setEV(boolean isEV) {
        this.isEV = isEV;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", type=" + type +
                ", isEV=" + isEV +
                '}';
    }
}