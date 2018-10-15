package com.example.dailyproblem;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		//method1();
		method2();
	}

	public static void method1() {
		int num = 17;

		int[] arr = { 10, 15, 3, 7 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] + arr[j] == num) {
					System.out.println(String.format("Found %s +  %s = %s", arr[i], arr[j], arr[i] + arr[j]));
					return;
				}
			}
		}
		System.out.println("No match found");
	}

	public static void method2() {
		int num = 18;
		int[] arr = { 10, 15, 3, 7 };

		Map<Integer, Integer> sumMap = new HashMap<>();
		for (int x : arr) {
			if (!sumMap.containsKey(x)) {
				sumMap.put(num - x, x);
			}
			else {
				System.out.println(String.format("Found %s + %s = %s", x, sumMap.get(x), num));
				return;
			}
		}
		System.out.println("No match found");
	}

}
