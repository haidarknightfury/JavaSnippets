package com.example.patterns.strategy_pattern.strategy.base;

public interface BaseStrategy<E> {

    public E convert(E param);
}
