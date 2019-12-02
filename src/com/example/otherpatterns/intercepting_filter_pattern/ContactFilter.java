package com.example.otherpatterns.intercepting_filter_pattern;

public class ContactFilter extends AbstractFilter {

    @Override
    public String execute(Order order) {
        String result = super.execute(order);
        if (order.getContactNumber() == null || order.getContactNumber().isEmpty() || order.getContactNumber().length() != 11) {
            return result + "Invalid contact Number";
        }
        return result;
    }

}
