package com.example.dailyproblem;

import java.util.Arrays;

public class Problem2 {

	public static void main(String[] args) {
		Integer [] arr = {1,2,3};
		Arrays.asList(getMultipliedArray(arr)).stream().forEach(System.out::println);
	}

	public static Integer[] getMultipliedArray(Integer[] array) {
		Integer arr[] = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			int mult = 1;
			for (int j = 0; j < array.length; j++) {
				if (i != j) {
					mult *= array[j];
				}
			}
			arr[i] = mult;
		}
		return arr;
	}

}
