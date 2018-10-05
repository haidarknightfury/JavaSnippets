package com.example.snippets.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

import io.reactivex.functions.Predicate;

/**
 * Managing zones- Using ZoneDateTime
 *
 * @author hdargaye
 *
 */
public class Example4 {

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dtf.format(dt));

        ZonedDateTime gmt = ZonedDateTime.now();
        ZonedDateTime gmtzone = ZonedDateTime.now(ZoneId.of("GMT+12"));
        System.err.println(dtf.format(gmtzone));

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("NY: " + dtf.format(ny));

        Set<String> zones = ZoneId.getAvailableZoneIds();
        Predicate<String> condition = str -> str.contains("London");

        zones.forEach(z -> {
            try {
                if (condition.test(z)) {
                    System.out.println(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // zones.forEach(System.out::println);

    }

}
