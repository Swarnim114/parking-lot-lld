import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingSpot> parkingSpots;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private PricingStrategy pricingStrategy;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private DistanceData distanceData;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.parkingSpots = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.distanceData = new DistanceData();

        // Default strategies
        this.pricingStrategy = new HourlyPricingStrategy();
        this.spotAssignmentStrategy = new NearestSpotAssignmentStrategy();

        // Load example distance data
        this.distanceData.loadExampleData();
    }

    public Ticket issueNewTicket(Vehicle vehicle, Gate entryGate) {
        // Find an available parking spot using the assignment strategy
        ParkingSpot availableSpot = spotAssignmentStrategy.findSpot(
                vehicle,
                parkingSpots,
                entryGate.getGateId(),
                distanceData);

        if (availableSpot == null) {
            return null; // No available spot
        }

        // Occupy the spot
        availableSpot.occupy();

        // Create and return ticket
        String ticketId = "TICKET_" + System.currentTimeMillis();
        return new Ticket(ticketId, vehicle, availableSpot, entryGate);
    }

    public double calculateFee(Ticket ticket) {
        return pricingStrategy.calculateCharges(ticket);
    }

    public void freeParkingSpot(Ticket ticket) {
        if (ticket.getParkingSpot() != null) {
            ticket.getParkingSpot().vacate();
        }
    }

    // Methods to add spots and gates
    public void addParkingSpot(ParkingSpot spot) {
        this.parkingSpots.add(spot);
    }

    public void addEntryGate(Gate gate) {
        if (gate instanceof EntryGate) {
            this.entryGates.add(gate);
        }
    }

    public void addExitGate(Gate gate) {
        if (gate instanceof ExitGate) {
            this.exitGates.add(gate);
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public SpotAssignmentStrategy getSpotAssignmentStrategy() {
        return spotAssignmentStrategy;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategy spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public DistanceData getDistanceData() {
        return distanceData;
    }

    public void setDistanceData(DistanceData distanceData) {
        this.distanceData = distanceData;
    }

    // Utility methods
    public int getAvailableSpots(VehicleType vehicleType) {
        return (int) parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType)
                .count();
    }

    public int getTotalSpots(VehicleType vehicleType) {
        return (int) parkingSpots.stream()
                .filter(spot -> spot.getSpotType() == vehicleType)
                .count();
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", totalSpots=" + parkingSpots.size() +
                ", entryGates=" + entryGates.size() +
                ", exitGates=" + exitGates.size() +
                '}';
    }
}