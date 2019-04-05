package com.example.patterns.proxy_pattern;

public class Main {

    public static void main(String[] args) {
        ConnectionAccess connectionAccess = new ProxiedConnection();
        connectionAccess.connectTo("smartfox");
        // connectionAccess.connectTo("baka.otaku");
    }
}
