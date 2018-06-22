package com.example.exercises.find_pair;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Find the pair
 */
public class Exercise2 {

    public static void main(String[] args) {
        Integer[] list = { 1, 2, 4, 4 };
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : list) {
            int res = num - key;
            map.put(key, res);
            if (map.containsKey(res) && map.get(res) == key) {
                System.out.println("found " + key + " " + res);
                return;
            }
        }

        System.out.println("not found");
        scanner.close();

    }
}
