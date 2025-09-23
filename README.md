

# Parking Lot Design

## Requirements
- Multiple types of parking spots for different vehicle types (e.g., car, bike, truck).
- Support for multiple floors.
- Some parking spots have additional features like charging for electric vehicles (EVs).
- Extra features (e.g., charging) incur additional costs.
- Ground floor has multiple entry and exit gates.
- Each gate has a human guard who issues tickets to customers.
- Parking spots are allocated using the "closest available spot" strategy.
- Entry is denied if no parking spots are available.

The design should:
- Follow SOLID principles.
- Apply useful design patterns.

---

## Class Diagram

```
@startuml
title Parking Lot Class Diagram - MVP

class ParkingLot {
    - string name 
    - string address 
    - List<ParkingSpot> parkingSpots
    - List<Gate> entryGates
    - List<Gate> exitGates  
    - PricingStrategy pricingStrategy
    + boolean isParkingAvailable(VehicleType type)
    + ParkingSpot assignParkingSpot(Vehicle vehicle)
    + double calculateFee(Ticket ticket)
}

abstract class Gate {
    - int gateNo 
    - Guard guard 
}

class EntryGate {
    + Ticket generateTicket(Vehicle vehicle)
}

class ExitGate {
    + Payment processPayment(Ticket ticket)
}

class Guard {
    - string name
    - int age 
    + Ticket generateTicket(Vehicle vehicle)
}

enum VehicleType {
    BIKE
    CAR
    TRUCK
}

class Vehicle {
    - string licenseNumber
    - VehicleType type
    - boolean isEV
}

class Ticket {
    - string ticketId
    - Date entryTime
    - Date exitTime
    - Vehicle vehicle
    - ParkingSpot parkingSpot
    - Gate entryGate
    + double calculateDuration()
}

abstract class ParkingSpot {
    - string spotId
    - VehicleType spotType
    - boolean isAvailable
    - boolean hasCharging
    - double baseRate
    - int floorNumber
    + boolean canParkVehicle(Vehicle vehicle)
    + double calculateAdditionalCharges()
}

class BikeSpot {
    - boolean isElectricCharging
}

class CarSpot {
    - boolean isElectricCharging
}

class TruckSpot {
    - boolean isElectricCharging
}

interface PricingStrategy {
    + double calculateCharges(Ticket ticket)
}

class HourlyPricingStrategy {
    - double hourlyRate
    - double evChargingFee
    + double calculateCharges(Ticket ticket)
}

class Payment {
    - string paymentId
    - double amount
    - Date paymentTime
    - PaymentStatus status
    + boolean processPayment()
}

enum PaymentStatus {
    PENDING
    COMPLETED
    FAILED
}

' Relationships
ParkingLot "1" *-- "*" ParkingSpot : manages
ParkingLot "1" *-- "*" Gate : has
ParkingLot "1" *-- "1" PricingStrategy : uses

Gate "1" o-- "1" Guard : assigned to
EntryGate --|> Gate
ExitGate --|> Gate

ParkingSpot <|-- BikeSpot
ParkingSpot <|-- CarSpot
ParkingSpot <|-- TruckSpot

Ticket "1" *-- "1" Vehicle : for
Ticket "1" *-- "1" ParkingSpot : assigned to
Ticket "1" *-- "1" EntryGate : issued at

Vehicle "1" *-- "1" VehicleType : categorized as

PricingStrategy <|.. HourlyPricingStrategy : implements

ExitGate "1" *-- "*" Payment : processes
Payment "1" *-- "1" PaymentStatus : has

EntryGate "1" *-- "*" Ticket : generates
Guard "1" *-- "*" Ticket : issues

@enduml
```

---

## Class Diagram Image

![alt text](classDiagram.png)

