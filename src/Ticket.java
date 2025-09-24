import java.util.Date;

public class Ticket {
    private String ticketId;
    private Date entryTime;
    private Date exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private PaymentStatus paymentStatus;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, Gate entryGate) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGate = entryGate;
        this.entryTime = new Date(); // Current time
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", entryGate=" + entryGate +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}