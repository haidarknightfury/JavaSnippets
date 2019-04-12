package com.example.patterns.service_locator_pattern;

public class EmployeeService implements Service {

    @Override
    public void execute() {
        System.out.println("Executing employee service");
    }

    @Override
    public String getServiceName() {
        return "Employee Service";
    }

}
