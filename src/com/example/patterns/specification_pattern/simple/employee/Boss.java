package com.example.patterns.specification_pattern.simple.employee;

import com.example.patterns.specification_pattern.simple.property.Sector;

public class Boss extends AbstractEmployee {

    public Boss(String name, Integer age) {
        super(name, age, Sector.MGT);
    }

}
