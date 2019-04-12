package com.example.patterns.intercepting_filter_pattern;

public class Client {

    private FilterManager filterManager;

    public void sendRequest(String request) {
        this.filterManager.filterRequest(request);
    }

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }
}
