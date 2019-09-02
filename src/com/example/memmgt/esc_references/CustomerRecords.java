package com.example.memmgt.esc_references;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer> {

    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer customer) {
        this.records.put(customer.getName(), customer);
    }

    // Not a good code, the reference can be obtained from outside and the state will change by code outside the class
    // Almost as if has declared records as public; can have invalid values in the collection map
    public Map<String, Customer> getCustomers() {
        // return this.records;
        // return new HashMap<String, Customer>(this.records); - Still not a good alternative
        return Collections.unmodifiableMap(this.records);
    }

    public CustomerReadOnly getCustomerByName(String name) {
        // return this.records.get(name); // ESCAPING REFERENCES - Solution is to provide a readonly customer
        return new Customer(this.records.get(name));
    }

    @Override
    public Iterator<Customer> iterator() {
        return this.records.values().iterator();
    }

    public static void main(String[] args) {
        CustomerRecords customerRecords = new CustomerRecords();
        customerRecords.addCustomer(new Customer("baka", "12346"));
        // customerRecords.getCustomers().put("bnaka", new Customer("bnaka", "bnana")); - Unsupported method

        // Copy of customer - can be confusing - partial fix
        CustomerReadOnly baka = customerRecords.getCustomerByName("baka");

    }

}
