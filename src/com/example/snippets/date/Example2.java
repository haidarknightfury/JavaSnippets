package com.example.snippets.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Example2 {

    public static void main(String[] args) {

        /**
         * Get in current time zone
         */

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        // Java Date - Jan = 0, LocalDate : Jan = 1
        LocalDate specificDate = LocalDate.of(2020, 5, 25);
        System.out.println(specificDate);

        // Only time
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        // Specific Time
        LocalTime specificTime = LocalTime.of(14, 0, 45);
        System.out.println(specificTime);

        // Date time
        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println(currentDT);

        // Specific Date Time
        LocalDateTime currentDTSpecific = LocalDateTime.of(specificDate, specificTime);
        System.out.println(currentDTSpecific);

    }

}
