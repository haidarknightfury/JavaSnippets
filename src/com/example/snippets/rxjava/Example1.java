package com.example.snippets.rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {

        // Just is a factory method for creating an Observable
        Flowable.just("Hello world").subscribe(System.out::println);

        // Create an observable of tweets
        Observable<String> tweets = Observable.just("Learning RX Java", "Java rocks");
        // Observer subscribe to observable
        tweets.subscribe(System.out::println);

        List<String> arrString = Arrays.asList("Hello", "Haidar");
        Observable<String> nameObservable = Observable.fromIterable(arrString);
        nameObservable.subscribe(System.out::println);

        Observable<Integer> naturalNum = naturalNumbers(2);
        naturalNum.subscribe(num -> System.out.println("Hello" + num));
        naturalNum.subscribe(num -> System.out.println("Shine" + num));
        naturalNum.subscribe(num -> System.out.println("Die" + num));

        // emit only when connect is called - publish to convert cold observable to hot
        // cold observable - receive past values and future values
        // hot observable - reecive only future values
        ConnectableObservable<Long> hotObservable = Observable.interval(1, TimeUnit.SECONDS).publish();
        hotObservable.subscribe(val -> System.out.println("OBS1: " + val));

        // now that observable will emit
        hotObservable.connect();

        Thread.sleep(5000);

        hotObservable.subscribe(val -> System.out.println("OBS2: " + val));

        Thread.sleep(5000);

    }

    /**
     * Create an observable - using create factory
     *
     * @param Observable
     * @return
     */
    public static Observable<Integer> naturalNumbers(int n) {
        return Observable.create(subscriber -> {
            IntStream.rangeClosed(1, n).forEach(number -> {
                subscriber.onNext(number);
            });
        });
    }

}
