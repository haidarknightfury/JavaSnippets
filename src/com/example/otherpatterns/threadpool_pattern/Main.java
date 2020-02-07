package com.example.otherpatterns.threadpool_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new EmployeeBasicProcessingTask(5));
        tasks.add(new EmployeeAdvancedProcessingTask(4));
        tasks.add(new EmployeeBasicProcessingTask(2));
        tasks.add(new EmployeeAdvancedProcessingTask(2));
        tasks.add(new EmployeeBasicProcessingTask(5));
        tasks.add(new EmployeeAdvancedProcessingTask(4));
        tasks.add(new EmployeeBasicProcessingTask(2));
        tasks.add(new EmployeeAdvancedProcessingTask(2));
        tasks.add(new EmployeeBasicProcessingTask(5));
        tasks.add(new EmployeeAdvancedProcessingTask(4));
        tasks.add(new EmployeeBasicProcessingTask(2));
        tasks.add(new EmployeeAdvancedProcessingTask(2));
        tasks.add(new EmployeeBasicProcessingTask(5));
        tasks.add(new EmployeeAdvancedProcessingTask(4));
        tasks.add(new EmployeeBasicProcessingTask(2));
        tasks.add(new EmployeeAdvancedProcessingTask(2));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < tasks.size(); i++) {
            Runnable worker = new Worker(tasks.get(i));
            executorService.execute(worker);
        }

        // shutdown
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.yield();
        }

        System.out.println("finished");
    }

}
