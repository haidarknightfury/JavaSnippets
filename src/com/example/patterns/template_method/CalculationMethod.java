package com.example.patterns.template_method;

public abstract class CalculationMethod {

    public CalculationMethod() {
    }

    public void calculate() {
        System.out.println(this.getCalculationMethodName());
        System.out.println(this.getTotal() - this.getDiscount());
    }

    protected abstract String getCalculationMethodName();

    protected abstract int getDiscount();

    protected abstract int getTotal();

}
