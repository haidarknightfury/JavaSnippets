package com.example.exercises.exercism;

/**
 * https://exercism.io/my/solutions/825e35303f56495cb2e5dd64207f7187
 * 
 * @author hdargaye
 *
 */
public class ArmstrongNumbers_1 {

    public static void main(String[] args) {
        System.out.println(isArmstrong(9));
        System.out.println(isArmstrong(10));
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(154));
    }

    public static Boolean isArmstrong(int intialNumber) {
        int number = intialNumber;
        int size = String.valueOf(number).length();
        int sum = 0;
        while (number > 0) {
            sum += (Math.pow(number % 10, size));
            number = number / 10;
        }
        return sum == intialNumber;
    }

}
