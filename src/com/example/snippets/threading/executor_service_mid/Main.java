package com.example.snippets.threading.executor_service_mid;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {

    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        List<Callable<Long>> callableSums = new ArrayList<>();
        int num_per_thread = list.size() / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            callableSums.add(new CallableSum(list, i * num_per_thread, (i + 1) * num_per_thread - 1));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            List<Future<Long>> results = executorService.invokeAll(callableSums);
            List<Long> result = results.stream().map(future ->
                {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return 0L;
                }).collect(Collectors.toList());

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
