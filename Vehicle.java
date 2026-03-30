/*
 * Vehicle.java
 * 
 * Defines the Vehicle class hierarchy for the parking management system.
 * - Vehicle: Abstract parent class with vehicle number and rate methods
 * - Car: ₹50/day base rate
 * - Bike: ₹20/day base rate
 * - Cycle: ₹10/day base rate
 * 
 * The base rate is multiplied by the pass multiplier to calculate total fee.
 */

abstract class Vehicle {

    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    abstract int getBaseRate();
    abstract String getType();
}

class Car extends Vehicle {

    Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    int getBaseRate() {
        return 50;
    }

    String getType() {
        return "Car";
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    int getBaseRate() {
        return 20;
    }

    String getType() {
        return "Bike";
    }
}

class Cycle extends Vehicle {

    Cycle(String vehicleNumber) {
        super(vehicleNumber);
    }

    int getBaseRate() {
        return 10;
    }

    String getType() {
        return "Cycle";
    }
}