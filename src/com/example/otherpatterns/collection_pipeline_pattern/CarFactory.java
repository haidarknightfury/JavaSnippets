package com.example.otherpatterns.collection_pipeline_pattern;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> createCars() {
        return Arrays.asList(new Car("Jeep", "Wrangler", 2011, Category.JEEP), new Car("Jeep", "Wrangler", 2011, Category.JEEP), new Car("Jeep", "Wrangler", 2011, Category.JEEP),
                new Car("Jeep", "Wrangler", 2011, Category.JEEP));
    }

}
