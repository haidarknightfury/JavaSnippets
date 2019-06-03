package com.example.patterns.decorator.decorator_2;

public class Main {

    public static void main(String[] args) {
        User user = new User("haidar", "haidar");
        System.out.println(user.toString());

        System.out.println(new SecureUser(user).toString());

    }
}
