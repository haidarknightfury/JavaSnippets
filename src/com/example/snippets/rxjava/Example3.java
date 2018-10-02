package com.example.snippets.rxjava;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Example3 {

    public static void main(String args[]) {

        // Ignore onNext before subscribe call
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);

        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(System.out::println);
        replaySubject.onNext(1);
        replaySubject.subscribe(System.out::println);
        replaySubject.onNext(2);
        replaySubject.onNext(3);
    }
}
