package com.example.otherpatterns.async_method_invocation_pattern;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncExecutor executor = new ThreadAsyncExecutor();
        AsyncResult<Integer> asyncResult = executor.startProcess(lazyVal(10, 500));

        asyncResult.await();
        Integer result = asyncResult.getValue();
        System.out.println(result);

        AsyncResult<String> asyncResult2 = executor.startProcess(lazyVal("test", 300), callback("result2"));
        System.out.println(executor.endProcess(asyncResult2));

    }

    public static <T> Callable<T> lazyVal(T value, long delayMillis) {
        return () ->
            {
                Thread.sleep(delayMillis);
                System.out.println("Complemeted with value of " + value);
                return value;
            };
    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) ->
            {
                if (ex.isPresent()) {
                    System.out.println(name + " failed " + ex.map(Exception::getMessage).orElse(""));
                } else {
                    System.out.println(name + " : " + value);
                }
            };
    }

}
