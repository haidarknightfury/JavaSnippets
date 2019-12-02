package com.example.otherpatterns.resource_aquisition_initialization_pattern;

import java.io.Closeable;
import java.io.IOException;

public class AquireDB implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("Releasing DB....");
    }

}
