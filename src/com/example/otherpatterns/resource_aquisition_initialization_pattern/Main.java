package com.example.otherpatterns.resource_aquisition_initialization_pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        try (AquireDB DB = new AquireDB()) {
            System.out.println("Aquiring DB");
        }

        try (AquireMsg MSG = new AquireMsg()) {
            System.out.println("Aquiring Msg");
        }
    }
}
