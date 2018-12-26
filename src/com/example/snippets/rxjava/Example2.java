package com.example.snippets.rxjava;

import io.reactivex.Observable;

public class Example2 {

    public static void main(String[] args) {

        // 6. Transformation on Observables- same as stream api
        Observable<String> strings = Observable.just("Hello", "Name", "Haidar");
        strings.map(tweet -> tweet.length()).forEach(System.out::println);

        // 7. count
        strings.count().toFlowable().subscribe(System.out::println);

        // 8. Reduce operations
        System.out.println("--REDUCE OPERATIONS--");
        strings.map(tweet -> tweet.length()).reduce(0, (acc, el) -> acc + el).toFlowable().subscribe(System.out::println);

    }
}
