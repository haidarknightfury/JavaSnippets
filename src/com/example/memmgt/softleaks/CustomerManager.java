package com.example.memmgt.softleaks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerManager {

    private List<Customer> customers = new ArrayList<Customer>();
    private int nextId = 0;

    public void addCustomer(Customer customer) {
        synchronized (this) {
            customer.setId(this.nextId);
            this.nextId++;
        }
        this.customers.add(customer);
    }

    public Customer getNextCustomer() {
        //
        // Customer result = null;
        // synchronized (this) {
        // if (this.customers.size() > 0) {
        // result = this.customers.remove(0);
        // }
        // }
        //
        // return result;

        return this.customers.get(0);
    }

    public void howManyCustomers() {
        int size = 0;
        size = this.customers.size();
        System.out.println("" + new Date() + " : " + size);
    }

    public void displayCustomers() {
        synchronized (this.customers) {
            for (Customer c : this.customers) {
                System.out.println(c.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
