/*
 * Pass.java
 * 
 * Defines the Pass class hierarchy for the parking management system.
 * - Pass: Abstract parent class with multiplier, duration, and expiry methods
 * - DailyPass: 1-day validity, multiplier = 1
 * - WeeklyPass: 7-day validity, multiplier = 5 
 * - AnnualPass: 1-year validity, multiplier = 20 
 * 
 * Multipliers are used in fee calculation: Total Fee = Base Rate × Multiplier
 */

import java.time.LocalDate;

abstract class Pass {

    abstract int getMultiplier();
    abstract String getDuration();
    abstract LocalDate getExpiryDate(LocalDate issueDate);
}

class DailyPass extends Pass {

    int getMultiplier() {
        return 1;
    }

    String getDuration() {
        return "Daily";
    }

    LocalDate getExpiryDate(LocalDate issueDate) {
        return issueDate.plusDays(1);
    }
}

class WeeklyPass extends Pass {

    int getMultiplier() {
        return 5;
    }

    String getDuration() {
        return "Weekly";
    }

    LocalDate getExpiryDate(LocalDate issueDate) {
        return issueDate.plusWeeks(1);
    }
}

class AnnualPass extends Pass {

    int getMultiplier() {
        return 20;
    }

    String getDuration() {
        return "Annual";
    }

    LocalDate getExpiryDate(LocalDate issueDate) {
        return issueDate.plusYears(1);
    }
}