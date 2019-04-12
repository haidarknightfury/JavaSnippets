package com.example.patterns.service_locator_pattern;

public class InitialContext {

    public Object lookup(String jndiName) {
        if ("EmployeeService".equalsIgnoreCase(jndiName)) {
            return new EmployeeService();
        } else if ("CustomerService".equalsIgnoreCase(jndiName)) {
            return new CustomerService();
        }
        return null;
    }

}
