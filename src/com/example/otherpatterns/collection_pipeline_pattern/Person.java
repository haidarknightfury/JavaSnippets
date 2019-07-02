package com.example.otherpatterns.collection_pipeline_pattern;

import java.util.List;

public class Person {

    private List<Car> cars;

    public Person(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
