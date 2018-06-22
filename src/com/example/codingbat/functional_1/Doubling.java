package com.example.codingbat.functional_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Doubling {
    public static void main(String args[]) {
        System.out.println(doubling(Arrays.asList(1, 2, 3, 4, 5, 6)));
        System.out.println(doubling_m2(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    public static List<Integer> doubling(List<Integer> nums) {
        return nums.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    public static List<Integer> doubling_m2(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }

}
