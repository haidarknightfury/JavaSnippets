package com.example.otherpatterns.chain_pattern;

public class Main {

    public static void main(String[] args) {
        Root root = new Root();
        root.makeRequest(new Request(RequestType.LEVEL1, "Level 1 Request"));
        root.makeRequest(new Request(RequestType.LEVEL2, "Level 2 Request"));
    }
}
