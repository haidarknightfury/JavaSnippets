package com.example.otherpatterns.collection_pipeline_pattern;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = CarFactory.createCars();

        List<String> models = CarDomainOperations.getModelsAfter2000(cars);
        System.out.println(models);

        Map<Category, List<Car>> map = CarDomainOperations.getGroupingOfCarsByCategory(cars);
        System.out.println(map);
    }
}
