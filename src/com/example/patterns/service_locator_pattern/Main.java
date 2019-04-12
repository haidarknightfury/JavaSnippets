package com.example.patterns.service_locator_pattern;

public class Main {

    public static void main(String[] args) {
        Service service = Locator.getService("EmployeeService");
        service.execute();

        Service service1 = Locator.getService("CustomerService");
        service1.execute();
    }
}
