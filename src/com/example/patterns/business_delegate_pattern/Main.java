package com.example.patterns.business_delegate_pattern;

public class Main {

    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setType("EJB");

        Client client = new Client(businessDelegate);
        client.process();

        businessDelegate.setType("JMS");
        client.process();

    }

}
