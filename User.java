/*
 * User.java
 * 
 * Defines the User class hierarchy for the parking management system.
 * - User: Abstract parent class with name and fee calculation methods
 * - Student: Pays calculated parking fees based on vehicle and pass type
 * - Teacher: Receives free parking (fee = 0)
 */

abstract class User {
    String name;

    User(String name) {
        this.name = name;
    }

    abstract int calculateFee(Vehicle vehicle, Pass pass);
    abstract String getType();
}

class Student extends User {

    Student(String name) {
        super(name);
    }

    @Override
    int calculateFee(Vehicle vehicle, Pass pass) {
        return vehicle.getBaseRate() * pass.getMultiplier();
    }

    @Override
    String getType() {
        return "Student";
    }
}

class Teacher extends User {

    Teacher(String name) {
        super(name);
    }

    @Override
    int calculateFee(Vehicle vehicle, Pass pass) {
        return 0; 
    }

    @Override
    String getType() {
        return "Teacher";
    }
}