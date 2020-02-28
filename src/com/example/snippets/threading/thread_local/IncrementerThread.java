package com.example.snippets.threading.thread_local;

public class IncrementerThread extends Thread {

    private ThreadLocal<Integer> incrementerCounter;
    private String name;

    public IncrementerThread(ThreadLocal<Integer> td, String name) {
        this.incrementerCounter = td;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " : " + this.incrementerCounter.get());
            this.incrementerCounter.set(this.incrementerCounter.get() + 1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
