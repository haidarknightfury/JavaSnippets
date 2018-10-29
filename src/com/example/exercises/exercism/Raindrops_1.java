package com.example.exercises.exercism;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Raindrops_1 {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder("");

        List<Integer> refactors = getFactors(30);

        List<Integer> factors = getFactors(30).stream().filter(n -> n == 3 || n == 7 || n == 5).collect(Collectors.toList());
        factors.forEach(n -> {
            if (n == 3) {
                result.append("Pling");
            } else if (n == 5) {
                result.append("Plang");
            } else {
                result.append("Plong");
            }
        });
        System.out.println(result.toString());
    }

    public static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

}
