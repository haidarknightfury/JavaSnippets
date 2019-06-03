package com.example.exercises.exercism;

public class NthPrime_1 {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 6;
        int limit = 0;

        int number = 2;
        while (limit != n) {
            if (optimisedSqrt(number)) {
                limit++;
            }
            number++;
        }
        System.out.println(--number);

    }

    public static boolean optimisedSqrt(int n) {
        return isPrime(n);
    }
}
