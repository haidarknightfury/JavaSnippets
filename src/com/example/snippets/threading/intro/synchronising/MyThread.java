package com.example.snippets.threading.intro.synchronising;

public class MyThread extends Thread {

    private int threadId;
    private TargetFile target;

    public MyThread(int threadId, TargetFile target) {
        super();
        this.threadId = threadId;
        this.target = target;
    }

    @Override
    public void run() {

        // if did not synchronize all thread will run these at the same time
        // some resource cannot be shared
        synchronized (this.target) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.target.call(this.threadId);
        }

    }
}
