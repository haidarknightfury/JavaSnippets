package com.example.snippets.threading.intro;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int interations = 5;
        try {
            for (int i = 0; i < interations; i++) {
                System.out.println("From runnable : " + i);
                Thread.sleep(1500);
                // can interrupt the thread from the parent thread
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

}
