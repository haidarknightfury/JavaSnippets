package com.example.otherpatterns.intercepting_filter_pattern;

public class FilterManager {

    private FilterChain filterChain;

    public FilterManager() {
        this.filterChain = new FilterChain();
    }

    public void addFilter(Filter filter) {
        this.filterChain.addFilter(filter);
    }

    public String filterRequest(Order order) {
        return this.filterChain.execute(order);
    }
}
