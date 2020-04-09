package com.example.otherpatterns.throttle_pattern;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

import com.example.otherpatterns.throttle_pattern.timer.Throttler;

public class B2BService {

    private static Consumer<String> printer = System.out::println;
    private CallsCount callsCount;

    public B2BService(Throttler timer, CallsCount callsCount) {
        this.callsCount = callsCount;
        timer.start();
    }

    public int dummmyCustomerAPI(Tenant tenant) {
        String tenantName = tenant.getName();
        long count = this.callsCount.getCount(tenantName);
        printer.accept(String.format("Counter for {%s} : {%d} ", tenantName, count));
        if (count >= tenant.getAllowedCallsPerSecond()) {
            printer.accept(String.format("API access per second limit reached for : {%s} ", tenantName));
            return -1;
        }

        this.callsCount.incrementCount(tenantName);
        return this.getRandomCustomerId();
    }

    private int getRandomCustomerId() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }
}
