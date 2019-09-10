package com.example.patterns.chainofresponsibility.lambda2;

public interface Chain<T> {

    void handle(T t);
}
