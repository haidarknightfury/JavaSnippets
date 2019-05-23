package com.example.patterns.template_method;

public class DiscountedCalculationMethod extends CalculationMethod {

    public DiscountedCalculationMethod() {
        super();
    }

    @Override
    protected String getCalculationMethodName() {
        return "DISCOUNTED";
    }

    @Override
    protected int getDiscount() {
        return 20;
    }

    @Override
    protected int getTotal() {
        return 100;
    }

}
