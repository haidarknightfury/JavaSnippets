package com.example.otherpatterns.callback_pattern;

public class Main {

    public static void main(String[] args) {
        SimpleTask simpleTask = new SimpleTask();
        simpleTask.executeWith(() -> System.out.println("Finished"));
    }
}
