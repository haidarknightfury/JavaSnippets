package com.example.patterns.intercepting_filter_pattern;

public class AuthenticationFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Authentication Request : " + request);
    }

}
