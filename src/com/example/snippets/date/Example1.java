package com.example.snippets.date;

import java.time.Duration;
import java.time.Instant;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        // 1. LocalDate -> thread safe

        // Instant on java timeline - number of milliseconds
        // Current moment
        Instant start = Instant.now();
        System.out.println(start);

        Thread.sleep(1000);

        Instant end = Instant.now();
        System.out.println(end);

        Duration elapsed = Duration.between(start, end);
        // PT 0.047S -> 0.047 seconds
        System.out.println(elapsed);
        System.out.println(elapsed.toMillis());

    }

}
