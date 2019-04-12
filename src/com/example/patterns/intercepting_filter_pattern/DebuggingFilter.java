package com.example.patterns.intercepting_filter_pattern;

public class DebuggingFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Logging request " + request);
    }

}
