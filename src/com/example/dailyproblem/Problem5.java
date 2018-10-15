package com.example.dailyproblem;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Problem5 {

	static Function<BiFunction<Integer, Integer, Integer>, Integer> cons(Integer a, Integer b) {
		Function<BiFunction<Integer, Integer, Integer>, Integer> pair = (f) -> f.apply(a, b);
		return pair;
	}

	static Integer car(Function<BiFunction<Integer, Integer, Integer>, Integer> consFunction) {
		BiFunction<Integer, Integer, Integer> left = (x, y) -> x;
		return consFunction.apply(left);
	}

	static Integer cdr(Function<BiFunction<Integer, Integer, Integer>, Integer> consFunction) {
		BiFunction<Integer, Integer, Integer> right = (x, y) -> y;
		return consFunction.apply(right);
	}

	public static void main(String[] args) {
		System.out.println(car(cons(1, 2)));
		System.out.println(cdr(cons(1, 2)));
	}

}
