package com.example.snippets.optional.basic;

import java.util.Optional;

public class Example1 {
	
	public static void main(String [] args) {
		Example1 tester= new Example1();
		
		Integer value1=null;
		Integer value2= new Integer(10);
		
		// allow passed paramter to be null
		Optional<Integer> a = Optional.ofNullable(value1);
		
		// null pointer if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
	}
	
	public Integer sum(Optional<Integer> a , Optional<Integer> b) {
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());
		
		// return a if present else return 0
		Integer value1 = a.orElse(new Integer(0));
		
		// value should be present
		Integer value2 = b.get();
		
		return value1+ value2;
		
	}
}
