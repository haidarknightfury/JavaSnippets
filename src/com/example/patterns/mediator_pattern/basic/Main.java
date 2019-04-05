package com.example.patterns.mediator_pattern.basic;

public class Main {
    public static void main(String[] args) {
        User usr1 = new User("Baka");
        User usr2 = new User("Haidar");

        usr1.showMessage("Hello");
        usr2.showMessage("Boy");
    }
}
