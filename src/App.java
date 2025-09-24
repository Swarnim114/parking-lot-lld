public class App {
    public static void main(String[] args) {
        System.out.println("=== Parking Lot System Demo ===\n");

        // Create parking lot
        ParkingLot parkingLot = new ParkingLot("City Mall Parking", "123 Main Street");

        // Create guards
        Guard guard1 = new Guard("John", 30);
        Guard guard2 = new Guard("Jane", 25);
        Guard guard3 = new Guard("Bob", 35);
        Guard guard4 = new Guard("Alice", 28);

        // Create gates
        EntryGate entryGate1 = new EntryGate(1, guard1);
        EntryGate entryGate2 = new EntryGate(2, guard2);
        ExitGate exitGate1 = new ExitGate(3, guard3);
        ExitGate exitGate2 = new ExitGate(4, guard4);

        // Add gates to parking lot
        parkingLot.addEntryGate(entryGate1);
        parkingLot.addEntryGate(entryGate2);
        parkingLot.addExitGate(exitGate1);
        parkingLot.addExitGate(exitGate2);

        // Create parking spots based on the example data
        // Bike spots
        parkingLot.addParkingSpot(new RegularParkingSpot("B1", VehicleType.BIKE, false, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("B2", VehicleType.BIKE, true, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("B3", VehicleType.BIKE, false, 0));

        // Car spots
        parkingLot.addParkingSpot(new RegularParkingSpot("C1", VehicleType.CAR, true, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("C2", VehicleType.CAR, false, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("C3", VehicleType.CAR, true, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("C4", VehicleType.CAR, false, 0));

        // Truck spots
        parkingLot.addParkingSpot(new RegularParkingSpot("T1", VehicleType.TRUCK, false, 0));
        parkingLot.addParkingSpot(new RegularParkingSpot("T2", VehicleType.TRUCK, true, 0));

        System.out.println("Parking Lot Setup Complete!");
        System.out.println(parkingLot);
        printAvailability(parkingLot);

        // Demo 1: Regular car entry from Gate 1
        System.out.println("\n=== Demo 1: Regular Car Entry ===");
        Vehicle car1 = new Vehicle("ABC123", VehicleType.CAR, false);
        Ticket ticket1 = entryGate1.handleEntry(car1, parkingLot);
        printAvailability(parkingLot);

        // Demo 2: Electric car entry from Gate 2
        System.out.println("\n=== Demo 2: Electric Car Entry ===");
        Vehicle electricCar = new Vehicle("EV456", VehicleType.CAR, true);
        Ticket ticket2 = entryGate2.handleEntry(electricCar, parkingLot);
        printAvailability(parkingLot);

        // Demo 3: Bike entry from Gate 1
        System.out.println("\n=== Demo 3: Bike Entry ===");
        Vehicle bike1 = new Vehicle("BIKE789", VehicleType.BIKE, false);
        Ticket ticket3 = entryGate1.handleEntry(bike1, parkingLot);
        printAvailability(parkingLot);

        // Demo 4: Truck entry from Gate 2
        System.out.println("\n=== Demo 4: Truck Entry ===");
        Vehicle truck1 = new Vehicle("TRUCK001", VehicleType.TRUCK, false);
        Ticket ticket4 = entryGate2.handleEntry(truck1, parkingLot);
        printAvailability(parkingLot);

        // Simulate some time passing for fee calculation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle exception
        }

        // Demo 5: Exit processing
        System.out.println("\n=== Demo 5: Exit Processing ===");
        if (ticket1 != null) {
            System.out.println("Processing exit for regular car...");
            Payment payment1 = exitGate1.processExit(ticket1, parkingLot);
            System.out.println("Payment details: " + payment1);
        }

        if (ticket2 != null) {
            System.out.println("\nProcessing exit for electric car...");
            Payment payment2 = exitGate2.processExit(ticket2, parkingLot);
            System.out.println("Payment details: " + payment2);
        }

        printAvailability(parkingLot);

        // Demo 6: Attempt entry when no spots available for a type
        System.out.println("\n=== Demo 6: No Available Spots Scenario ===");
        // Fill up remaining car spots
        Vehicle car2 = new Vehicle("CAR002", VehicleType.CAR, false);
        Vehicle car3 = new Vehicle("CAR003", VehicleType.CAR, false);
        Vehicle car4 = new Vehicle("CAR004", VehicleType.CAR, false);

        entryGate1.handleEntry(car2, parkingLot);
        entryGate1.handleEntry(car3, parkingLot);
        entryGate1.handleEntry(car4, parkingLot); // This should be denied

        printAvailability(parkingLot);

        System.out.println("\n=== Demo Complete ===");
    }

    private static void printAvailability(ParkingLot parkingLot) {
        System.out.println("\n--- Current Availability ---");
        System.out.println("Bikes: " + parkingLot.getAvailableSpots(VehicleType.BIKE) + "/"
                + parkingLot.getTotalSpots(VehicleType.BIKE));
        System.out.println("Cars: " + parkingLot.getAvailableSpots(VehicleType.CAR) + "/"
                + parkingLot.getTotalSpots(VehicleType.CAR));
        System.out.println("Trucks: " + parkingLot.getAvailableSpots(VehicleType.TRUCK) + "/"
                + parkingLot.getTotalSpots(VehicleType.TRUCK));
    }
}
