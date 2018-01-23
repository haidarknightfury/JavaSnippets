package com.example.snippets.stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example1 {
	// stream() -Returns a sequential stream considering collection as its source.
	// parallelStream() - Returns a parallel Stream considering collection as its
	// source.

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("abc", "bc", "", "efg", "");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		// foreach
		Random random = new Random();
		//limit- reduce size of stream
		random.ints().limit(10).forEach(System.out::println);

		//map- map element to corresponding result
		List<Integer> numbers = Arrays.asList(3,4,5,6,7,8,2,4);
		List<Integer> squaresList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
		
		//get count of empty string
		long count = strings.stream().filter(string->string.isEmpty()).count();
		
	}

}
