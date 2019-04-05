package com.example.patterns.bridge.pattern_1;

public class ProducerWorkshop implements Workshop {

    @Override
    public void work() {
        System.out.println("Producing items");
    }

}
