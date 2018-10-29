package com.example.snippets.threading.intro;

public class MyThread extends Thread {

    @Override
    public void run() {
        int interations = 5;
        try {
            for (int i = 0; i < interations; i++) {
                System.out.println("From Secondary Threads : " + i);
                sleep(1000);
                // can interrupt the thread from the parent thread
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }

}
