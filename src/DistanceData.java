import java.util.Map;
import java.util.HashMap;

public class DistanceData {
    // Map of gateId -> (spotId -> distance)
    private Map<Integer, Map<String, Integer>> gateToSpotDistances;

    public DistanceData() {
        this.gateToSpotDistances = new HashMap<>();
    }

    public void addGateDistances(int gateId, Map<String, Integer> spotDistances) {
        gateToSpotDistances.put(gateId, spotDistances);
    }

    public Integer getDistance(int gateId, String spotId) {
        Map<String, Integer> spotDistances = gateToSpotDistances.get(gateId);
        if (spotDistances != null) {
            return spotDistances.get(spotId);
        }
        return null; // Or return a very large number to indicate unreachable
    }

    public Map<String, Integer> getDistancesFromGate(int gateId) {
        return gateToSpotDistances.get(gateId);
    }

    public boolean hasGate(int gateId) {
        return gateToSpotDistances.containsKey(gateId);
    }

    public void loadExampleData() {
        // Gate 1 distances (Entry Gate 1)
        Map<String, Integer> gate1Distances = new HashMap<>();
        gate1Distances.put("B1", 10);
        gate1Distances.put("B2", 15);
        gate1Distances.put("B3", 20);
        gate1Distances.put("C1", 12);
        gate1Distances.put("C2", 18);
        gate1Distances.put("C3", 25);
        gate1Distances.put("C4", 30);
        gate1Distances.put("T1", 35);
        gate1Distances.put("T2", 40);
        addGateDistances(1, gate1Distances);

        // Gate 2 distances (Entry Gate 2)
        Map<String, Integer> gate2Distances = new HashMap<>();
        gate2Distances.put("B1", 25);
        gate2Distances.put("B2", 20);
        gate2Distances.put("B3", 15);
        gate2Distances.put("C1", 28);
        gate2Distances.put("C2", 22);
        gate2Distances.put("C3", 16);
        gate2Distances.put("C4", 12);
        gate2Distances.put("T1", 18);
        gate2Distances.put("T2", 14);
        addGateDistances(2, gate2Distances);

        // Gate 3 distances (Exit Gate 1)
        Map<String, Integer> gate3Distances = new HashMap<>();
        gate3Distances.put("B1", 15);
        gate3Distances.put("B2", 12);
        gate3Distances.put("B3", 18);
        gate3Distances.put("C1", 20);
        gate3Distances.put("C2", 15);
        gate3Distances.put("C3", 22);
        gate3Distances.put("C4", 25);
        gate3Distances.put("T1", 28);
        gate3Distances.put("T2", 32);
        addGateDistances(3, gate3Distances);

        // Gate 4 distances (Exit Gate 2)
        Map<String, Integer> gate4Distances = new HashMap<>();
        gate4Distances.put("B1", 30);
        gate4Distances.put("B2", 28);
        gate4Distances.put("B3", 25);
        gate4Distances.put("C1", 35);
        gate4Distances.put("C2", 30);
        gate4Distances.put("C3", 25);
        gate4Distances.put("C4", 20);
        gate4Distances.put("T1", 15);
        gate4Distances.put("T2", 12);
        addGateDistances(4, gate4Distances);
    }
}