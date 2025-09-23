import java.util.List;

public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingSpot> parkingSpots;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private PricingStrategy pricingStrategy;

    public ParkingLot(String name, String address, List<ParkingSpot> parkingSpots, List<EntryGate> entryGates,
            List<ExitGate> exitGates, PricingStrategy pricingStrategy) {
        this.name = name;
        this.address = address;
        this.parkingSpots = parkingSpots;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.pricingStrategy = pricingStrategy;
    }

    public boolean isParkingAvailable(VehicleType type) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotType() == type && spot.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public ParkingSpot assignParkingSpot(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotType() == vehicle.getType() && spot.isAvailable()) {
                spot.setAvailable(false);
                return spot;
            }
        }
        return null;
    }

    public double calculateFee(Ticket ticket) {
        return pricingStrategy.calculateCharges(ticket);
    }
}
