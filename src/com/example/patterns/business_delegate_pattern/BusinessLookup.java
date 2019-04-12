package com.example.patterns.business_delegate_pattern;

public class BusinessLookup {
    public BusinessService getBusinessService(String type) {
        if ("ejb".equalsIgnoreCase(type)) {
            return new EJBService();
        } else if ("jms".equalsIgnoreCase(type)) {
            return new JMSService();
        }
        return null;
    }
}
