package com.example.snippets.threading.intro;

public class Example1 {

    public static void main(String[] args) {
        int iterations = 3;
        MyThread thread = new MyThread();
        thread.start();

        try {
            for (int i = 0; i < iterations; i++) {
                System.out.println("From main process");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
