package com.example.snippets.threading.executor_service_intro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {

        // Creating an executor service - An interface - Use Executors to provide an implementation
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable task1 = () ->
            {
                try {
                    System.out.println("TASK 1 With executor service");
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        // execute method to run the runnable class - Returns void
        executor.execute(task1);
    }
}
