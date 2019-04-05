package com.example.patterns.decorator.decorator_1;

// Feature can either be a base class or interface
public class BaseFeature implements Feature {

    @Override
    public String execute() {
        return "Executing basic feature";
    }

    @Override
    public String getName() {
        return "basic";
    }

}
