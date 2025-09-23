
public class HourlyPricingStrategy implements PricingStrategy {
    private double hourlyRate;
    private double evChargingFee;

    public HourlyPricingStrategy(double hourlyRate, double evChargingFee) {
        this.hourlyRate = hourlyRate;
        this.evChargingFee = evChargingFee;
    }

    @Override
    public double calculateCharges(Ticket ticket) {
        double duration = ticket.calculateDuration();
        double charges = duration * hourlyRate;
        if (ticket.getParkingSpot().hasCharging() && ticket.getVehicle().isEV()) {
            charges += evChargingFee;
        }
        return charges;
    }
}
