
package com.example.patterns.template_method;

public class Main {

    public static void main(String[] args) {
        MyProduct myProduct = new MyProduct(new DiscountedCalculationMethod(), 100);
        myProduct.calculate();
    }
}
