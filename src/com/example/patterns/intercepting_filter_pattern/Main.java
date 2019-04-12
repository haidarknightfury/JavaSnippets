package com.example.patterns.intercepting_filter_pattern;

public class Main {

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.addFilter(new AuthenticationFilter());
        filterManager.addFilter(new DebuggingFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("Index");

    }
}
