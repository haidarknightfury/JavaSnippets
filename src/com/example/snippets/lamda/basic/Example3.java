package com.example.snippets.lamda.basic;

public class Example3 {

    public static void main(String[] args) {
        NumericTest testEven = (n) -> n % 2 == 0;
        NumericTest testOdd = (n) -> !testEven.test(n);

        System.out.println(testEven.test(10));
        System.out.println(testOdd.test(10));
    }

    interface NumericTest {
        boolean test(int n);
    }

}
