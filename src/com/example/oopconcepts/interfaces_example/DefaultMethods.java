package com.example.oopconcepts.interfaces_example;

public class DefaultMethods {

    public interface vehicle {

        default void print() {
            System.out.println("A Vehicle");
        }
    }

    public interface fourWheeler {
        default void print() {
            System.out.println("Four wheeler");
        }

    }

    public class Car implements vehicle, fourWheeler {

        @Override
        public void print() {
            // if more than one interfaces is implemented or create own default method
            fourWheeler.super.print();
            vehicle.super.print();
        }

    }

    public static void main(String[] args) {
        Car car = new DefaultMethods().new Car();
        car.print();

    }

}
