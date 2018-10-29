package com.example.snippets.threading.intro;

public class Example3InterruptThread {
    public static void main(String args[]) {
        MyThread t = new MyThread();
        t.start();

        try {
            Thread.sleep(2500);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Called interrupt");
        t.interrupt();
    }
}
