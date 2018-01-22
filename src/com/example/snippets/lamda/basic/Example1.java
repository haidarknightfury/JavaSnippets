package com.example.snippets.lamda.basic;

import java.util.function.Predicate;

public class Example1 {
	public static void main(String[] args) {
		Predicate<String> predicateString = s -> {
			return s.equals("Hello");
		};

		System.out.println(predicateString.test("Hello"));
		System.out.println(predicateString.test("Hello world"));

		Predicate<Integer> predicateInteger = i -> {
			return i > 0;
		};

		System.out.println(predicateInteger.test(5));
		System.out.println(predicateInteger.test(-5));
	}
}
