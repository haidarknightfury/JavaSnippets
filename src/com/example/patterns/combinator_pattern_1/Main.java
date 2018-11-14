package com.example.patterns.combinator_pattern_1;

import static com.example.patterns.combinator_pattern_1.UserValidation.emailContainsAt;
import static com.example.patterns.combinator_pattern_1.UserValidation.nameNotEmpty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("HD", 22, "haidar@mail.com");
        nameNotEmpty().and(emailContainsAt()).apply(user);
        findUsers().stream().parallel().filter(nameNotEmpty().and(emailContainsAt())::apply).collect(Collectors.toList());

    }

    public static List<User> findUsers() {
        return Arrays.asList(new User("HD", 22, "haidar@mail.com"),
                new User("HD", 22, "haidar@mail.com"),
                new User("HD", 22, "haidar@mail.com"));
    }
}
