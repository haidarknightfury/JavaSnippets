package com.example.patterns.combinator_pattern_2;

import static com.example.patterns.combinator_pattern_2.UserValidation.nameIsNotEmpty;

import com.example.patterns.combinator_pattern_1.User;

public class Main {

    public static void main(String args[]) {

        UserValidation validation = nameIsNotEmpty();
        ValidationResult result = validation.apply(new User("", 22, "h@mail.com"));
        result.getReason().ifPresent(System.out::println);
    }

}
