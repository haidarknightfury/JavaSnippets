package com.example.otherpatterns.threadpool_pattern;

public class Worker implements Runnable {

    private final Task task;

    public Worker(final Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s processing %s", Thread.currentThread().getName(), this.task.toString()));
        try {
            Thread.sleep(this.task.getTimeMs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
