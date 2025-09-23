
public class EntryGate extends Gate {
    private ParkingLot parkingLot;

    public EntryGate(int gateNo, Guard guard, ParkingLot parkingLot) {
        super(gateNo, guard);
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        if (!parkingLot.isParkingAvailable(vehicle.getType())) {
            System.out.println("Parking is full for " + vehicle.getType());
            return null;
        }
        ParkingSpot parkingSpot = parkingLot.assignParkingSpot(vehicle);
        if (parkingSpot == null) {
            System.out.println("Could not assign parking spot.");
            return null;
        }
        String ticketId = "TICKET-" + System.currentTimeMillis();
        return new Ticket(ticketId, vehicle, parkingSpot, this);
    }
}
