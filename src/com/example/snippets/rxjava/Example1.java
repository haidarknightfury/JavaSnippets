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

        // 1. Just is a factory method for creating an Observable
        Flowable.just("Hello world").subscribe(System.out::println);

        // 2. Create an observable of tweets
        Observable<String> tweets = Observable.just("Learning RX Java", "Java rocks");
        // Observer subscribe to observable
        tweets.subscribe(System.out::println);

        // 3. Create an observable from a list
        List<String> arrString = Arrays.asList("Hello", "Haidar");
        Observable<String> nameObservable = Observable.fromIterable(arrString);
        nameObservable.subscribe(System.out::println);

        // 4. Create an observable method - Different method for subscription
        Observable<Integer> naturalNum = naturalNumbers(2);
        naturalNum.subscribe(num -> System.out.println("Hello" + num));
        naturalNum.subscribe(num -> System.out.println("Shine" + num));
        naturalNum.subscribe(num -> System.out.println("Die" + num));

        // 5. Emit values after an interval
        // emit only when connect is called - .publish to convert cold observable to hot
        // cold observable - receive past values and future values
        // hot observable - reecive only future values
        // he publish method returns a Observable of type ConnectableObservable. A ConnectableObservable does not begin emitting items when an Observer is subscribed to it, but when its connect method
        // is called.
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
            // Use an IntStream to create a stream of numbers
            IntStream.rangeClosed(1, n).forEach(number -> {
                subscriber.onNext(number);
            });
        });
    }

}
