import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots, int gateId, DistanceData distanceData);
}