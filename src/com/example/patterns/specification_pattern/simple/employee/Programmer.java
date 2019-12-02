package com.example.patterns.specification_pattern.simple.employee;

import com.example.patterns.specification_pattern.simple.property.Sector;

public class Programmer extends AbstractEmployee {

    public Programmer(String name, Integer age) {
        super(name, age, Sector.IT);
    }

}
