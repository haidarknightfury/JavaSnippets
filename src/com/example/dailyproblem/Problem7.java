package com.example.dailyproblem;

public class Problem7 {

    public static void main(String[] args) {
        System.out.println(possibilities("777"));
    }

    public static int possibilities(String message) {

        if (message.length() == 0) {
            return 0;
        }

        if (message.length() == 1) {
            return 1;
        }

        String firstTwo = message.substring(0, 2);
        if (Integer.valueOf(firstTwo) <= 26) {
            return 2 + possibilities(message.substring(2));
        } else {
            return 0 + possibilities(message.substring(1));
        }

    }

}
