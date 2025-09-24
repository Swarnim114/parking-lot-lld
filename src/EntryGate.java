public class EntryGate extends Gate {

    public EntryGate(int gateId, Guard guard) {
        super(gateId, guard);
    }

    public Ticket handleEntry(Vehicle vehicle, ParkingLot parkingLot) {
        System.out.println("Entry Gate " + gateId + " (Guard: " + guard.getName() + ") processing vehicle: "
                + vehicle.getLicenseNumber());

        // Delegate to ParkingLot for ticket creation
        Ticket ticket = parkingLot.issueNewTicket(vehicle, this);

        if (ticket != null) {
            System.out.println(
                    "Ticket issued: " + ticket.getTicketId() + " for spot: " + ticket.getParkingSpot().getSpotId());
        } else {
            System.out.println("Entry denied - No available spots for vehicle type: " + vehicle.getType());
        }

        return ticket;
    }
}