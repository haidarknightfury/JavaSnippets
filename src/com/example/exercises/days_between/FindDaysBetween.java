package com.example.exercises.days_between;

public class FindDaysBetween {

    public static void main(String[] args) {
        Date d1 = new Date(30, 01, 2016);
        System.out.println(d1.calculateDays(new Date(01, 01, 2016)));
    }

}
