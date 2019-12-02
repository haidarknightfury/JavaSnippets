package com.example.otherpatterns.intercepting_filter_pattern;

public interface Filter {

    String execute(Order order);

    void setNext(Filter filter);

    Filter getNext();

    Filter getLast();
}
