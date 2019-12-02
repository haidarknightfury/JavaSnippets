package com.example.memmgt;

import java.util.ArrayList;

import com.example.memmgt.softleaks.Customer;

public class CheckingGC {

    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        while (true) {
            customers.add(new Customer("bakaa"));
            if (customers.size() >= 100) {
                for (int i = 0; i < 10; i++) {
                    customers.remove(0);
                }
            }
        }
    }
}
