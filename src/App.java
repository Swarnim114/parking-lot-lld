import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new BikeSpot("B1", false, 10, 0));
        parkingSpots.add(new CarSpot("C1", true, 20, 0));
        parkingSpots.add(new TruckSpot("T1", false, 30, 0));

        PricingStrategy pricingStrategy = new HourlyPricingStrategy(20, 5);

        List<EntryGate> entryGates = new ArrayList<>();
        List<ExitGate> exitGates = new ArrayList<>();

        ParkingLot parkingLot = new ParkingLot("My Parking Lot", "123 Main St", parkingSpots, entryGates, exitGates,
                pricingStrategy);

        Guard entryGuard = new Guard("John", 30);
        EntryGate entryGate = new EntryGate(1, entryGuard, parkingLot);
        entryGates.add(entryGate);

        Guard exitGuard = new Guard("Doe", 35);
        ExitGate exitGate = new ExitGate(2, exitGuard, parkingLot);
        exitGates.add(exitGate);

        Vehicle car = new Vehicle("CAR-123", VehicleType.CAR, true);
        Ticket ticket = entryGate.generateTicket(car);

        if (ticket != null) {
            System.out.println("Ticket generated: " + ticket.getTicketId());
            try {
                Thread.sleep(2000); // Simulate parking for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exitGate.processPayment(ticket);
            System.out.println("Payment processed. Vehicle exited.");
        }
    }
}
