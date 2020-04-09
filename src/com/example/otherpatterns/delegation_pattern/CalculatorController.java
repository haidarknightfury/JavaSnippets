package com.example.otherpatterns.delegation_pattern;

public class CalculatorController implements Calculator {

    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Integer calculate(Integer salary) {
        return this.calculator.calculate(salary);
    }

}
