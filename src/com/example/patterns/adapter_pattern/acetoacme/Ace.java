package com.example.patterns.adapter_pattern.acetoacme;

public class Ace implements AceInterface {

    String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

}
