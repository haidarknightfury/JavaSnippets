package com.example.patterns.bridge.pattern_1;

public class Main {
    public static void main(String[] args) {

        /**
         * Bridge - link between workshop and vehicle
         * vehicle is an abstract having common behavior
         * vehicle takes in workshops which are interfaces - having similar behaviour
         * manufacture method is abstract
         */
        Vehicle vehicle1 = new Car(new ProducerWorkshop(), new AssemblerWorkshop());
        vehicle1.manufacture();

        Vehicle vehicle2 = new Bike(new ProducerWorkshop(), new AssemblerWorkshop());
        vehicle2.manufacture();
    }
}
