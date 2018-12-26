package com.example.snippets.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Example3 {

    public static void main(String args[]) {

        /**
         * 1. Observable - push based composable iterator - push items to an observable
         * - onNext() - passes each item one at a time from source observable to Observer
         * - onComplete() - signal completion - no more onNext()
         * - onError() - signal error - retry() to intercept error
         *
         * Observer - Consumes the items
         */

        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        source.subscribe(s -> System.out.println("Received : " + s), Throwable::printStackTrace);

        // Converting an Observable to Another - Regroup multiple RXJava Operations
        // New Observable yuelded to receive emissions - map and filter are also an observable
        Observable<Integer> lengthObservable = source.map(String::length);
        Observable<Integer> filtered = lengthObservable.filter(i -> i >= 5);
        filtered.subscribe(System.out::println); // Pass in a Consumer that will trigger onNext

        /**
         * 2. Chaining Observables
         */
        System.out.println("--Chaining Observables");
        source.map(String::length).filter(i -> i >= 5).subscribe(System.out::println);

        /**
         * 3. Creating own Observer
         */
        System.out.println("--Own Observable--");
        Observable<String> nameObservable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer t) {
                System.out.println("Received : " + t);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!!");
            }
        };
        nameObservable.map(String::length).filter(i -> i >= 5).subscribe(myObserver);

        /**
         * 4. Creating Own Observer with Lamdas
         */
        Consumer<Integer> onNext = i -> System.out.println("Received " + i);
        Consumer<Throwable> onError = Throwable::printStackTrace;
        Action onComplete = () -> System.out.println("Done!");
        nameObservable.map(String::length).subscribe(onNext, onError, onComplete);

        /**
         * Connectable Observable - Hot Observable - will not process each observer at a time +multicasting
         * emission goes to all observers simulataneously
         * publish() - to convert Observable to hot
         * connect() to fire emissions - must set up all observer beforehand
         */

        ConnectableObservable<String> connectableObservable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").publish();
        connectableObservable.subscribe(s -> System.out.println("Observable 1: " + s));
        connectableObservable.map(String::length).subscribe(s -> System.out.println("Observable 2 " + s));
        connectableObservable.connect();

        // Ignore onNext before subscribe call
        System.out.println("--Publish Subject Test--");
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);

        // Replay Subject - even if subscribe later , will replay
        System.out.println("--Replay Subject--");
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(System.out::println);
        replaySubject.onNext(1);
        replaySubject.subscribe(System.out::println);
        replaySubject.onNext(2);
        replaySubject.onNext(3);
    }
}
