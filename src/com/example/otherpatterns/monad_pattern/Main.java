package com.example.otherpatterns.monad_pattern;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        User user = new User("user", 24, Sex.M, "h@m.com");
        User validated = Validator.of(user).validate(User::getName, Objects::nonNull, "Name is null").validate(User::getName, name -> !name.isEmpty(), "name is empty")
                .validate(User::getAge, age -> age > 25, "age is greater than 25").get();
        System.out.println(validated);
    }
}
