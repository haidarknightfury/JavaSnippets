package com.example.otherpatterns.throttle_pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.otherpatterns.throttle_pattern.timer.ThrottleTimerImpl;
import com.example.otherpatterns.throttle_pattern.timer.Throttler;

public class Main {

    public static void main(String[] args) {
        CallsCount callsCount = new CallsCount();
        Tenant adidas = new Tenant("Adidas", 5, callsCount);
        Tenant nike = new Tenant("Nike", 6, callsCount);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> makeServiceCalls(adidas, callsCount));
        executorService.execute(() -> makeServiceCalls(nike, callsCount));
        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void makeServiceCalls(Tenant tenant, CallsCount callsCount) {
        Throttler timer = new ThrottleTimerImpl(10, callsCount);
        B2BService service = new B2BService(timer, callsCount);
        for (int i = 0; i < 20; i++) {
            service.dummmyCustomerAPI(tenant);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
