package com.example.snippets.threading.intro;

public class Example2 {

    public static void main(String[] args) {
        int iterations = 3;

        MyThread thread = new MyThread();
        thread.start();

        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();

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
