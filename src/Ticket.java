import java.util.Date;

public class Ticket {
    private String ticketId;
    private Date entryTime;
    private Date exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, Gate entryGate) {
        this.ticketId = ticketId;
        this.entryTime = new Date();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGate = entryGate;
    }

    public double calculateDuration() {
        if (exitTime == null) {
            return (new Date().getTime() - entryTime.getTime()) / (1000.0 * 60 * 60);
        }
        return (exitTime.getTime() - entryTime.getTime()) / (1000.0 * 60 * 60);
    }

    public String getTicketId() {
        return ticketId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
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
}
