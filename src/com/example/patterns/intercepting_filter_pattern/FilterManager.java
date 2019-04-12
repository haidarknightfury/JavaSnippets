package com.example.patterns.intercepting_filter_pattern;

public class FilterManager {

    FilterChain filterChain;

    public FilterManager(Target target) {
        this.filterChain = new FilterChain();
        this.filterChain.setTarget(target);
    }

    public void addFilter(Filter filter) {
        this.filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        this.filterChain.execute(request);
    }
}
