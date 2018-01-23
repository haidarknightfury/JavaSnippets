package com.example.snippets.predicate.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example3 {
	public static void main(String [] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//method test to test if true or false
		// will always return true not matter what value of n
		System.out.println("ALL");
		Predicate<Integer> predicate = n-> true;
		eval(list, predicate);
		
		System.out.println("even");
		Predicate<Integer> evenPredicate = n-> n%2==0;
		eval(list,evenPredicate);
		
		System.out.println("greater than 3");
		Predicate <Integer> greaterthan3 = n->n>3;
		eval(list, greaterthan3);
		
		System.out.println("greater than 5");
		eval(list, n->n >5);
		
	}
	
	public static void eval(List<Integer>list , Predicate<Integer> predicate) {
		for(Integer n:list) {
				if(predicate.test(n)) {
					System.out.println(n);
				}
		}
	}
}
