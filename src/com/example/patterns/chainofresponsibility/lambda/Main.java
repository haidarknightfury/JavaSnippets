package com.example.patterns.chainofresponsibility.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = (text) -> "From haidar" + text;
        UnaryOperator<String> spellChecker = (text) -> text.replace("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellChecker);
        String result = pipeline.apply("labda hello ");
        System.out.println(result);
    }
}
