package com.example.patterns.template_method;

public abstract class Product {

    protected CalculationMethod method;
    private int price;

    public Product(CalculationMethod method, int price) {
        this.method = method;
        this.setPrice(price);
    }

    public void calculate() {
        this.method.calculate();
    }

    public void changeMethod(CalculationMethod method) {
        this.method = method;
    }

    protected int getPrice() {
        return this.price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

}
