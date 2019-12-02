package com.example.patterns.specification_pattern.simple.employee;

import com.example.patterns.specification_pattern.simple.property.Sector;

public abstract class AbstractEmployee {

    private String name;
    private Integer age;
    private Sector sector;

    public AbstractEmployee(String name, Integer age, Sector sector) {
        this.name = name;
        this.age = age;
        this.sector = sector;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Sector getSector() {
        return this.sector;
    }

    @Override
    public String toString() {
        return "AbstractEmployee [name=" + this.name + ", age=" + this.age + ", sector=" + this.sector + "]";
    }

}
