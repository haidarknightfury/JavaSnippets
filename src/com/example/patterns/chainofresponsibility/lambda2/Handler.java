package com.example.patterns.chainofresponsibility.lambda2;

public interface Handler<T> {

    // true if the request was handled, false if the request should be processed by the successor
    boolean handle(T t);
}
