package com.example.patterns.business_delegate_pattern;

public class JMSService implements BusinessService {

    @Override
    public void process() {
        System.out.println("Processing using JMS Service");
    }

}
