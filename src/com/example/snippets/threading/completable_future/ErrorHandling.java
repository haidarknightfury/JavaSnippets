package com.example.snippets.threading.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ErrorHandling {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Handling errrors in Completable future - exceptionally block - catches only the
        int age = -1;
        CompletableFuture<String> afuture = CompletableFuture.supplyAsync(() ->
            {
                if (age < 0) {
                    throw new IllegalArgumentException("wrong age");
                } else if (age > 18) {
                    return "adult";
                } else {
                    return "child";
                }

                // triggers only if exception happens
            }).exceptionally((error) ->
                {
                    System.out.println(error.getMessage());
                    return "Unknown";
                });
        System.out.println(afuture.get());

        // 2. Error handling using handle
        CompletableFuture<String> handleFuture = CompletableFuture.supplyAsync(() ->
            {
                if (age < 0) {
                    throw new IllegalArgumentException("wrong age");
                } else if (age > 18) {
                    return "adult";
                } else {
                    return "child";
                }

                // handle is always triggered whether or not exception happens
            }).handle((res, exception) ->
                {
                    if (exception != null) {
                        System.out.println(exception.getMessage());
                        return "unknown";
                    }
                    return res;
                });
        System.out.println(handleFuture.get());

    }

}
