package com.example.otherpatterns.intercepting_filter_pattern;

public class Order {

    private String name;
    private String contactNumber;
    private String address;
    private String depositNumber;
    private String orderItem;

    public Order() {

    }

    public Order(String name, String contactNumber, String address, String depositNumber, String orderItem) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.depositNumber = depositNumber;
        this.orderItem = orderItem;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepositNumber() {
        return this.depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public String getOrderItem() {
        return this.orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

}
