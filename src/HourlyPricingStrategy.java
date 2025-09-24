import java.util.Date;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final double BIKE_HOURLY_RATE = 5.0;
    private static final double CAR_HOURLY_RATE = 10.0;
    private static final double TRUCK_HOURLY_RATE = 20.0;
    private static final double EV_CHARGING_RATE = 15.0; // Additional cost per hour for EV charging

    @Override
    public double calculateCharges(Ticket ticket) {
        if (ticket.getExitTime() == null) {
            ticket.setExitTime(new Date()); // Set current time as exit time if not set
        }

        long durationMillis = ticket.getExitTime().getTime() - ticket.getEntryTime().getTime();
        double durationHours = Math.ceil(durationMillis / (1000.0 * 60 * 60)); // Round up to next hour

        if (durationHours <= 0) {
            durationHours = 1; // Minimum 1 hour charge
        }

        double baseRate = getBaseRate(ticket.getVehicle().getType());
        double totalCost = baseRate * durationHours;

        // Add EV charging cost if applicable
        if (ticket.getVehicle().isEV() && ticket.getParkingSpot().hasCharging()) {
            totalCost += EV_CHARGING_RATE * durationHours;
        }

        return totalCost;
    }

    private double getBaseRate(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return BIKE_HOURLY_RATE;
            case CAR:
                return CAR_HOURLY_RATE;
            case TRUCK:
                return TRUCK_HOURLY_RATE;
            default:
                return CAR_HOURLY_RATE;
        }
    }
}