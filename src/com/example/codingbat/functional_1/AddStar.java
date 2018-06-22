package com.example.codingbat.functional_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddStar {

    public static void main(String[] args) {
        System.out.println(addStar(Arrays.asList("1", "2", "awsd")));
    }

    public static List<String> addStar(List<String> strings) {
        strings.replaceAll(str -> str + "*");
        return strings;
    }

    public List<String> noX(List<String> strings) {
        return strings.stream().map(str -> {
            String counter = "";
            for (int i = 0; i < str.length(); i++) {
                if (!Character.toString(str.charAt(i)).equals("x")) {
                    counter += str.charAt(i);
                }
            }
            return counter;
        }).collect(Collectors.toList());
    }
}
