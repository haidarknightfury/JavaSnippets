package com.example.codingbat.recursion_1;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(noX("asxxxxc"));
    }

    /**
     * Factorial
     *
     * @param n
     * @return factorial
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     *
     * We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears
     * across all the bunnies recursively (without loops or multiplication).
     *
     * bunnyEars(0) 0
     * bunnyEars(1) 2
     * bunnyEars(2) 4
     */

    public static int bunnyEars(int n) {
        if (n == 0) {
            return 0;
        }
        return 2 + bunnyEars(n - 1);
    }

    /**
     *
     * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3
     * blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle
     * with the given number of rows.
     *
     *
     * triangle(0) 0
     * triangle(1) 1
     * triangle(2) 3
     */

    public static int triangle(int n) {
        if (n == 0) {
            return 0;
        }
        return n + triangle(n - 1);
    }

    /**
     *
     * Given a string, compute recursively a new string where all the 'x' chars have been removed.
     *
     *
     * noX("xaxb") "ab"
     * noX("abc") "abc"
     * noX("xx") ""
     */

    public static String noX(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'x') {
            return "" + noX(str.substring(1));
        } else {
            return ch + noX(str.substring(1));
        }
    }

}
