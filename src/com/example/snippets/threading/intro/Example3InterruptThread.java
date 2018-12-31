package com.example.snippets.threading.intro;

public class Example3InterruptThread {
    public static void main(String args[]) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();

        // Sleep main thread - MyThread continue to be processed
        Thread.sleep(2500);

        System.out.println("Called interrupt from main thread");
        t.interrupt();
    }
}
