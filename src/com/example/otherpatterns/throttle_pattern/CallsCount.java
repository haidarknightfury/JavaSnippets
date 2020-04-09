package com.example.otherpatterns.throttle_pattern;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CallsCount {

    private Map<String, AtomicLong> tenantCallsCount = new ConcurrentHashMap<String, AtomicLong>();

    public void addTenant(String tenantName) {
        this.tenantCallsCount.putIfAbsent(tenantName, new AtomicLong(0));
    }

    public void incrementCount(String tenantName) {
        this.tenantCallsCount.get(tenantName).incrementAndGet();
    }

    public long getCount(String tenantName) {
        return this.tenantCallsCount.get(tenantName).get();
    }

    public void reset() {
        for (Entry<String, AtomicLong> entry : this.tenantCallsCount.entrySet()) {
            this.tenantCallsCount.put(entry.getKey(), new AtomicLong(0));
        }
    }
}
