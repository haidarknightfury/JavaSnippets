package com.example.otherpatterns.convertor_pattern;

public class Main {

    public static void main(String[] args) {
        UserDTO user = new UserDTO("haidar", "hdargaye", "pwd");
        User newUser = new UserConvertor().convertFromDto(user);
        System.out.println(newUser);
    }
}
