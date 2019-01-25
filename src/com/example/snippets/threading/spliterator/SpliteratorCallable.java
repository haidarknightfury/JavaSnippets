package com.example.snippets.threading.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpliteratorCallable {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 1. Generating list using stream
        Random random = new Random();
        String tg = "ABCDEDGHIJKLMNOPQRSTUVWXYZ";

        List<Utility> utilities = Stream.generate(() -> new Utility(String.valueOf(tg.charAt(random.nextInt(tg.length()))))).limit(10).collect(Collectors.toList());

        Spliterator<Utility> split1 = utilities.spliterator();
        Spliterator<Utility> split2 = split1.trySplit();

        Callable<String> split1calable = new UtilityCallable(split1);
        Callable<String> split2calable = new UtilityCallable(split2);

        List<Future<String>> resultset = executorService.invokeAll(Arrays.asList(split1calable, split2calable));
        resultset.forEach(r ->
            {
                try {
                    System.out.println(r.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

    }

}
