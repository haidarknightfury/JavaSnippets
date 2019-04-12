package com.example.patterns.service_locator_pattern;

public class CustomerService implements Service {

    @Override
    public void execute() {
        System.out.println("Executing customer service");
    }

    @Override
    public String getServiceName() {
        return "Customer Service";
    }

}
