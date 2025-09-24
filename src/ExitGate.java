public class ExitGate extends Gate {

    public ExitGate(int gateId, Guard guard) {
        super(gateId, guard);
    }

    public Payment processExit(Ticket ticket, ParkingLot parkingLot) {
        System.out.println(
                "Exit Gate " + gateId + " (Guard: " + guard.getName() + ") processing ticket: " + ticket.getTicketId());

        // Calculate fee using ParkingLot
        double fee = parkingLot.calculateFee(ticket);
        System.out.println("Calculated fee: $" + fee);

        // Create payment
        String paymentId = "PAY_" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, fee);

        // Process payment
        boolean paymentSuccess = payment.process();

        if (paymentSuccess) {
            ticket.setPaymentStatus(PaymentStatus.COMPLETED);
            // Free the parking spot
            parkingLot.freeParkingSpot(ticket);
            System.out
                    .println("Payment successful. Spot " + ticket.getParkingSpot().getSpotId() + " is now available.");
        } else {
            System.out.println("Payment failed for ticket: " + ticket.getTicketId());
        }

        return payment;
    }
}