package com.example.patterns.template_method;

public class MyProduct extends Product {

    public MyProduct(CalculationMethod method, int price) {
        super(method, price);
    }

    @Override
    public void calculate() {
        this.method.calculate();
    }

}
