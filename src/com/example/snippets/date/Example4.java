package com.example.snippets.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TimeZone;

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

        ZoneId z = ZoneId.systemDefault();
        System.out.println(z.getRules());
        ZonedDateTime timeOfDefaultTimeZone = ZonedDateTime.now(z);
        System.out.println(timeOfDefaultTimeZone.toLocalTime());

        System.out.println("You have only " + getNumDaysBtw(LocalDate.of(2018, 12, 31)) + " day Left");

    }

    public static String getTimeFromLocalDateTime(LocalDateTime time, TimeZone tz) {
        // Get the time in UTC
        ZonedDateTime zonedDateTime = ZonedDateTime.of(time, ZoneOffset.UTC);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        // format the time in the correct time zone
        return timeFormatter.format(zonedDateTime.withZoneSameInstant(tz.toZoneId()));
    }

    public static long getNumDaysBtw(LocalDate end) {
        return ChronoUnit.DAYS.between(LocalDate.now(), end);
    }

}
