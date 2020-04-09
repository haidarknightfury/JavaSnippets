package com.example.otherpatterns.throttle_pattern;

public final class Tenant {

    private String name;
    private int allowedCallsPerSecond;

    public Tenant(String name, int allowedCallsPerSecond, CallsCount callsCount) {
        super();
        this.name = name;
        this.allowedCallsPerSecond = allowedCallsPerSecond;
        callsCount.addTenant(name);
    }

    public String getName() {
        return this.name;
    }

    public int getAllowedCallsPerSecond() {
        return this.allowedCallsPerSecond;
    }

}
