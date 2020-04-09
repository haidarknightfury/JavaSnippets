package com.example.otherpatterns.delegation_pattern;

import com.example.otherpatterns.delegation_pattern.calculators.BonusCalculator;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new BonusCalculator();
        CalculatorController calculatorController = new CalculatorController(calculator);
        System.out.println(calculatorController.calculate(10000));
    }

}
