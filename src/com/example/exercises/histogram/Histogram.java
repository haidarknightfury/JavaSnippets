package com.example.exercises.histogram;

import java.util.HashMap;

public class Histogram {

    public static void main(String[] args) {
        Integer arr[] = { 2, 4, 5, 2, 3, 4, 1, 5, 3, 3, 4 };
        int sum = 0, mean, median = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            sum += i;
        }

        map.entrySet().forEach((entry) -> {
            System.out.print(entry.getKey() + " | ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("*");
            }
            System.out.println();
        });

    }
}
