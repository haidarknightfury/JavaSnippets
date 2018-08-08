package com.example.snippets.threading.basic;

public class Thread1 {

    static class Animation implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("hello world from" + Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1.Animation(), "thread1");
        Thread t2 = new Thread(new Thread1.Animation(), "thread2");
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

    }
}
