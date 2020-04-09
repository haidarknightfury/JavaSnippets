package com.example.otherpatterns.delegation_pattern.calculators;

import com.example.otherpatterns.delegation_pattern.Calculator;

public class BonusCalculator implements Calculator {

    @Override
    public Integer calculate(Integer salary) {
        return (int) (salary * 1.5);
    }

}
