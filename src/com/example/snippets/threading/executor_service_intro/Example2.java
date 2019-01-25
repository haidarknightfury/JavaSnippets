package com.example.snippets.threading.executor_service_intro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Example2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Creating an executor service - An interface - Use Executors to provide an implementation
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Callable interface - Thread which returns a value
        Callable<String> task2 = () ->
            {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello From Task 2";
            };

        // execute method to run the callable method
        Future<String> result = executor.submit(task2);
        System.out.println("result from callable : " + result.get()); // Wait For Completion here and returns the result

        // 2. List of callables + Invoke Any
        Callable<String> task3 = () ->
            {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                return "Hello From Task 3";
            };
        List<Callable<String>> list = new ArrayList<Callable<String>>();
        list.add(task2);
        list.add(task3);
        // Executes the given tasks, returning the result of one that has completed successfully - Other threads are interrupted
        String result2 = executor.invokeAny(list);
        System.out.println(result2);

        // 3. Combining list of results from callable
        List<Future<String>> futureResults = executor.invokeAll(list);
        List<String> results = futureResults.stream().map(fut ->
            {
                try {
                    return fut.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }).collect(Collectors.toList());
        System.out.println(results);

    }
}
