package com.example.patterns.business_delegate_pattern;

public class Client {
    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void process() {
        this.businessDelegate.process();
    }
}
