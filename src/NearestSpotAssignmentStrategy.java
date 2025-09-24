import java.util.List;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots, int gateId, DistanceData distanceData) {
        ParkingSpot nearestSpot = null;
        int minDistance = Integer.MAX_VALUE;

        // Filter available spots that match the vehicle type
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotType() == vehicle.getType()) {
                // Check if EV needs charging spot
                if (vehicle.isEV() && !spot.hasCharging()) {
                    continue; // Skip non-charging spots for EVs
                }

                Integer distance = distanceData.getDistance(gateId, spot.getSpotId());
                if (distance != null && distance < minDistance) {
                    minDistance = distance;
                    nearestSpot = spot;
                }
            }
        }

        // If no charging spot found for EV, try to find any available spot of correct
        // type
        if (nearestSpot == null && vehicle.isEV()) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getSpotType() == vehicle.getType()) {
                    Integer distance = distanceData.getDistance(gateId, spot.getSpotId());
                    if (distance != null && distance < minDistance) {
                        minDistance = distance;
                        nearestSpot = spot;
                    }
                }
            }
        }

        return nearestSpot;
    }
}