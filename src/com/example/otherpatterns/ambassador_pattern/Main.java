package com.example.otherpatterns.ambassador_pattern;

public class Main {

    public static void main(String[] args) {
        Client host1 = new Client();
        host1.useService(100);
    }
}
