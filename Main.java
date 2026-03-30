/*
 * Ownwer-> Yadav Adarsh Ramesh
 * Date-> 20/01/2026
 * Parking Management System
 * These is a project in which the system collects information about the person, 
   their vehicle, and how long they want to park, then calculates a price and prints a receipt.
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static int ticketCounter = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = null;
        boolean validUser = false;

        while (!validUser) {
        System.out.print("Enter user type (1.student / 2.teacher): ");
        String userType = sc.nextLine();

            if (userType.equals("1") || userType.equalsIgnoreCase("student")) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                user = new Student(name);
                validUser = true;
            } 
            else if (userType.equals("2") || userType.equalsIgnoreCase("teacher")) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                user = new Teacher(name);
                validUser = true;
            } 
            else {
                System.out.println("Sorry, wrong input provided.\n");
            }
        }

        Vehicle vehicle = null;
        boolean validVehicle = false;

        while (!validVehicle) {

            System.out.print("Enter vehicle type (1.car / 2.bike / 3.cycle): ");
            String vehicleType = sc.nextLine();

            if (vehicleType.equals("1") || vehicleType.equalsIgnoreCase("car")) {
                System.out.print("Enter vehicle number: ");
                String vehicleNumber = sc.nextLine();
                vehicle = new Car(vehicleNumber);
                validVehicle = true;
            } 
            else if (vehicleType.equals("2") || vehicleType.equalsIgnoreCase("bike")) {
                System.out.print("Enter vehicle number: ");
                String vehicleNumber = sc.nextLine();
                vehicle = new Bike(vehicleNumber);
                validVehicle = true;
            } 
            else if (vehicleType.equals("3") || vehicleType.equalsIgnoreCase("cycle")) {
                System.out.print("Enter vehicle number: ");
                String vehicleNumber = sc.nextLine();
                vehicle = new Cycle(vehicleNumber);
                validVehicle = true;
            } 
            else {
                System.out.println("Sorry, wrong input provided.\n");
            }
        }

        Pass pass = null;
        boolean validPass = false;

        while (!validPass) {
            System.out.print("Enter pass type (1.daily / 2.weekly / 3.annual): ");
            String passType = sc.nextLine();

            if (passType.equals("1") || passType.equalsIgnoreCase("daily")) {
                pass = new DailyPass();
                validPass = true;
            } 
            else if (passType.equals("2") || passType.equalsIgnoreCase("weekly")) {
                pass = new WeeklyPass();
                validPass = true;
            } 
            else if (passType.equals("3") || passType.equalsIgnoreCase("annual")) {
                pass = new AnnualPass();
                validPass = true;
            } 
            else {
                System.out.println("Sorry, wrong input provided.\n");
            }
        }

        int fee = user.calculateFee(vehicle, pass);

        int ticketId = ticketCounter++;
        LocalDate issueDate = LocalDate.now();
        LocalDate expiryDate = pass.getExpiryDate(issueDate);

        // Ticket
        System.out.println("\n----------- PARKING TICKET -----------");
        System.out.println("Ticket ID    : T" + ticketId);
        System.out.println("Name         : " + user.name);
        System.out.println("User Type    : " + user.getType());
        System.out.println("Vehicle Type : " + vehicle.getType());
        System.out.println("Vehicle No   : " + vehicle.vehicleNumber);
        System.out.println("Pass Type    : " + pass.getDuration());
        System.out.println("Issue Date   : " + issueDate);
        System.out.println("Expiry Date  : " + expiryDate);
        System.out.println("Fee          : ₹" + fee);
        System.out.println("-------------------------------------");

        sc.close();
    }
}