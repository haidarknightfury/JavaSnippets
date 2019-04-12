package com.example.patterns.business_delegate_pattern;

public class EJBService implements BusinessService {

    @Override
    public void process() {
        System.out.println("Processing using EJB service");
    }

}
