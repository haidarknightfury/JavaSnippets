package com.example.patterns.proxy_pattern;

public class RealConnection implements ConnectionAccess {

    @Override
    public void connectTo(String host) {
        System.out.println("Connected to " + host);
    }

}
