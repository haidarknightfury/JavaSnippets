package com.example.patterns.specification_pattern.simple.selector;

import java.util.function.Predicate;

import com.example.patterns.specification_pattern.simple.employee.AbstractEmployee;

public class AgeSelector implements Predicate<AbstractEmployee> {

    private final Integer age;

    public AgeSelector(Integer age) {
        this.age = age;
    }

    @Override
    public boolean test(AbstractEmployee emp) {
        return emp.getAge() >= this.age;
    }

}
