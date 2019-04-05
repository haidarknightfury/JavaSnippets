package com.example.patterns.visitor_pattern.basic;

public class Pen implements Item {

    int model;
    int price;

    public Pen(int price, int model) {
        super();
        this.price = price;
        this.model = model;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getModel() {
        return this.model;
    }

    public int getPrice() {
        return this.price;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
