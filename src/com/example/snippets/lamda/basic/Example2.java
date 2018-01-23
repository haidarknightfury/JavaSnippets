package com.example.snippets.lamda.basic;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
	public static void main(String [] args) {
		
		List names= new ArrayList<>();
		names.add("Name 1");
		names.add("Name 2");
		
		//Here we have passed System.out::println method as a static method reference
		names.forEach(System.out::println);
	}
}
