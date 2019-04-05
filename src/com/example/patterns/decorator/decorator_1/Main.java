package com.example.patterns.decorator.decorator_1;

public class Main {

    public static void main(String[] args) {
        Feature feature = new ExcaliburFeature(new BaseFeature());
        Feature twiceExcalibur = new ExcaliburFeature(new ExcaliburFeature(new BaseFeature()));
        System.out.println(feature.execute());
        System.out.println(twiceExcalibur.execute());

    }
}
