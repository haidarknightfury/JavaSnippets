package com.example.otherpatterns.intercepting_filter_pattern;

public class FilterChain {

    private Filter chain;

    public void addFilter(Filter filter) {
        if (this.chain == null) {
            this.chain = filter;
        } else {
            this.chain.getLast().setNext(filter);
        }
    }

    public String execute(Order order) {
        if (this.chain != null) {
            return this.chain.execute(order);
        } else {
            return "RUNNING...";
        }
    }
}
