package com.example.snippets.threading.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class Basic {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Simplest completable future
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Hello");// manually completes the computable future
        System.out.println(completableFuture.get());

        // 2. Run a completable future asynchronously - takes a runnable as parameter
        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
            {
                try {
                    TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException e) {
                    throw new IllegalAccessError(e.toString());
                }
                System.out.println("Running in a separate thread");
            });
        future.get(); // wait for future to complete

        Supplier<String> futureStringSupplier = () ->
            {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hey there!!";
            };

        CompletableFuture<String> futureString = CompletableFuture.supplyAsync(futureStringSupplier);
        System.out.println(futureString.get());

        // 3. Using a thread pool, in Supply Async, pass executor as parameter

        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> futureStringExec = CompletableFuture.supplyAsync(futureStringSupplier, executor);
        System.out.println(futureStringExec.get());

        // 4. Chaining completable futures
        Function<String, String> capitalizeFunction = (str) ->
            {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return str.toUpperCase();

            };
        CompletableFuture<String> capitaliseFuture = futureString.thenApply(capitalizeFunction);
        System.out.println(capitaliseFuture.get());

        // 5. Completable future + Chaining
        CompletableFuture<String> completableFutureCombine = CompletableFuture.supplyAsync(() ->
            {
                return "Haidar";
            }).thenApply((str1) -> "Hello " + str1).thenApply((str) -> str.toUpperCase());
        System.out.println(completableFutureCombine.get());

        // 6. Can also chain with consumers - input but no returns
        CompletableFuture<Void> voidCompletable = CompletableFuture.supplyAsync(futureStringSupplier).thenAccept((str) -> System.out.println(str + "baka baka"));
        voidCompletable.get();

        // 7. thenRun -> doesnt have access to results of supplyAsync
        CompletableFuture<Void> thenRunFuture = CompletableFuture.runAsync(() -> System.out.println("First Part")).thenRunAsync(() -> System.out.println("Last part"));
        thenRunFuture.get();

        // https://www.callicoder.com/java-8-completablefuture-tutorial/
        // https://dzone.com/articles/20-examples-of-using-javas-completablefuture

    }

}
