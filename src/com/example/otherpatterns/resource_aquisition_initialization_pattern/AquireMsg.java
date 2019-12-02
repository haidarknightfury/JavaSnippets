package com.example.otherpatterns.resource_aquisition_initialization_pattern;

public class AquireMsg implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Releasing Msg....");
    }

}
