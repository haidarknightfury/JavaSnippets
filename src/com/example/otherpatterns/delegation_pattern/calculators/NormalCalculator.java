package com.example.otherpatterns.delegation_pattern.calculators;

import com.example.otherpatterns.delegation_pattern.Calculator;

public class NormalCalculator implements Calculator {

    @Override
    public Integer calculate(Integer salary) {
        return salary;
    }

}
