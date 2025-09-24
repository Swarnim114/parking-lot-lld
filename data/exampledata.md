# Example Distance Data for Parking Lot System

This file contains the example distance data used by the parking lot system to determine the closest available parking spot from each gate.

## Parking Spot Layout:
- **Bike Spots**: B1, B2, B3 (Ground floor)
- **Car Spots**: C1, C2, C3, C4 (Ground floor)
- **Truck Spots**: T1, T2 (Ground floor)

## Gate Layout:
- **Entry Gate 1** (ID: 1) - Left side of parking lot
- **Entry Gate 2** (ID: 2) - Right side of parking lot
- **Exit Gate 1** (ID: 3) - Middle-left of parking lot
- **Exit Gate 2** (ID: 4) - Middle-right of parking lot

## Distance Mappings:

### From Entry Gate 1 (Left side):
| Spot ID | Distance | Type  | Charging |
|---------|----------|-------|----------|
| B1      | 10       | BIKE  | No       |
| B2      | 15       | BIKE  | Yes      |
| B3      | 20       | BIKE  | No       |
| C1      | 12       | CAR   | Yes      |
| C2      | 18       | CAR   | No       |
| C3      | 25       | CAR   | Yes      |
| C4      | 30       | CAR   | No       |
| T1      | 35       | TRUCK | No       |
| T2      | 40       | TRUCK | Yes      |

### From Entry Gate 2 (Right side):
| Spot ID | Distance | Type  | Charging |
|---------|----------|-------|----------|
| B1      | 25       | BIKE  | No       |
| B2      | 20       | BIKE  | Yes      |
| B3      | 15       | BIKE  | No       |
| C1      | 28       | CAR   | Yes      |
| C2      | 22       | CAR   | No       |
| C3      | 16       | CAR   | Yes      |
| C4      | 12       | CAR   | No       |
| T1      | 18       | TRUCK | No       |
| T2      | 14       | TRUCK | Yes      |

### From Exit Gate 1 (Middle-left):
| Spot ID | Distance | Type  | Charging |
|---------|----------|-------|----------|
| B1      | 15       | BIKE  | No       |
| B2      | 12       | BIKE  | Yes      |
| B3      | 18       | BIKE  | No       |
| C1      | 20       | CAR   | Yes      |
| C2      | 15       | CAR   | No       |
| C3      | 22       | CAR   | Yes      |
| C4      | 25       | CAR   | No       |
| T1      | 28       | TRUCK | No       |
| T2      | 32       | TRUCK | Yes      |

### From Exit Gate 2 (Middle-right):
| Spot ID | Distance | Type  | Charging |
|---------|----------|-------|----------|
| B1      | 30       | BIKE  | No       |
| B2      | 28       | BIKE  | Yes      |
| B3      | 25       | BIKE  | No       |
| C1      | 35       | CAR   | Yes      |
| C2      | 30       | CAR   | No       |
| C3      | 25       | CAR   | Yes      |
| C4      | 20       | CAR   | No       |
| T1      | 15       | TRUCK | No       |
| T2      | 12       | TRUCK | Yes      |

## Notes:
- Distance is measured in arbitrary units (could represent meters, feet, or any distance measure)
- Charging spots are available for electric vehicles with additional cost
- The system prioritizes the nearest available spot of the correct vehicle type
- For electric vehicles, the system first tries to find charging spots, then falls back to regular spots if no charging spot is available