package com.example.snippets.lamda.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class Example1 {

    public static void main(String[] args) {

        // First Function - Input integer and Output String
        Function<Integer, String> myFunction = (x) -> "Hello" + x;
        // Predicate - take Output from function then checks for 1
        Predicate<String> myPredicate = y -> y.contains("1");

        // Composing Function - myFunction Ouput and myPredicate Input must be compatible
        Boolean result = myFunction.andThen(myPredicate::test).apply(2);
        System.out.println(result);

        // The result of composing the Function Taking Integer and returning True or false is Predicate taking integer and
        // returning true or false
        Predicate<Integer> finalPredicate = myFunction.andThen(myPredicate::test)::apply;
        Boolean res2 = finalPredicate.test(1);
        System.out.println(res2);
    }
}
