package com.example.otherpatterns.intercepting_filter_pattern;

public class OrderFilter extends AbstractFilter {

    @Override
    public String execute(Order order) {
        String result = super.execute(order);
        if (order.getOrderItem() == null || order.getOrderItem().isEmpty()) {
            return result + "Invalid order !";
        } else {
            return result;
        }
    }

}
