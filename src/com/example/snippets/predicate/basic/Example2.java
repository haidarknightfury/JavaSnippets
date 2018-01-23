package com.example.snippets.predicate.basic;

import java.util.function.Predicate;

public class Example2 {

	public static void main(String[] args) {
		Predicate<String> predicate = s -> {
			return s.equals("Hello");
		};

		// AND with predicate-> chaining more than one predicate
		Predicate<String> predicateAnd = predicate.and(s -> {
			return s.length() > 4;
		});
		System.out.println(predicateAnd.test("Hello"));

		// OR with predicate
		Predicate<String> predicateOr = predicate.or(s -> {
			return s.length() > 10;
		});
		System.out.println(predicateOr.test("morethantenchars"));

		//Negate with predicate
		Predicate<String> predicateNegate = predicate.negate();
		System.out.println(predicateNegate.test("Negation"));

	}

}
