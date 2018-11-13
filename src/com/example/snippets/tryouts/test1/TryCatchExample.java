package com.example.snippets.tryouts.test1;

public class TryCatchExample {

    public static void main(String[] args) {
        System.out.println(generateNumber(1));
    }

    public static int generateNumber(int y) {
        try {
            if (y > 2) {
                return y;
            }
            throw new RuntimeException();
        } finally {
            // finally always run -> before the return or before exception
            System.out.println("finally block");
        }
    }
}
