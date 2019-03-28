package com.example.snippets.threading.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Composition {

    public static CompletableFuture<String> getAnotherNameFuture(String name) {
        return CompletableFuture.supplyAsync(() -> name);
    }

    public static CompletableFuture<String> getNameFuture(String name) {
        return CompletableFuture.supplyAsync(() -> name);
    }

    public static CompletableFuture<Integer> getSizeFuture(String name) {
        return CompletableFuture.supplyAsync(() -> name.length());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Composable Completable Future are used to flatten the completable future - obtain at the top level
        CompletableFuture<Integer> result = getNameFuture("Haidar").thenCompose(name -> getSizeFuture(name));
        System.out.println(result.get());

        // 2. Combining Multiple Independent futures
        CompletableFuture<String> combineNamesFuture = getNameFuture("Haidar").thenCombine(getAnotherNameFuture("Dargaye"), (fname, lname) ->
            {
                return fname + " " + lname; // Callback called when both futures complete
            });
        System.out.println(combineNamesFuture.get());

        // 3. List of parallel futures
        List<String> names = Arrays.asList("Haidar", "Atom", "Baka");
        List<CompletableFuture<String>> allFutures = names.stream().map(name -> getNameFuture(name)).collect(Collectors.toList());

        // 4. Combine the futures in allFuture
        CompletableFuture<Void> allFutureCombined = CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[allFutures.size()]));
        CompletableFuture<List<String>> results = allFutureCombined.thenApply(v ->
            {
                List<String> res = allFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
                return res;
            });
        System.out.println(results.get());

        // 5. Any of - get the future that completes first
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(getAnotherNameFuture("Haidar"), getNameFuture("Baka"), getSizeFuture("Baka"));
        System.out.println(anyFuture.get());

    }
}
