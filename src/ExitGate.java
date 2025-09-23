
public class ExitGate extends Gate {
    private ParkingLot parkingLot;

    public ExitGate(int gateNo, Guard guard, ParkingLot parkingLot) {
        super(gateNo, guard);
        this.parkingLot = parkingLot;
    }

    public Payment processPayment(Ticket ticket) {
        double amount = parkingLot.calculateFee(ticket);
        String paymentId = "PAYMENT-" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, amount);
        if (payment.processPayment()) {
            ticket.getParkingSpot().setAvailable(true);
            return payment;
        }
        return null;
    }
}
