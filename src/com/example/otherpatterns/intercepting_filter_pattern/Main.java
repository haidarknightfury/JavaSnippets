package com.example.otherpatterns.intercepting_filter_pattern;

public class Main {

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new OrderFilter());
        filterManager.addFilter(new ContactFilter());

        Order order = new Order();
        order.setOrderItem("123456");
        order.setContactNumber("12345678291");

        String result = filterManager.filterRequest(order);
        System.out.println(result);

        Order order1 = new Order();
        result = filterManager.filterRequest(order1);
        System.out.println(result);
    }
}
