package com.example.patterns.decorator.decorator_1;

public class ExcaliburFeature implements Feature {

    private Feature feature;

    public ExcaliburFeature(Feature feature) {
        this.feature = feature;
    }

    @Override
    public String execute() {
        return this.feature.execute() + " + excalibur";
    }

    @Override
    public String getName() {
        return "excalibur";

    }

}
