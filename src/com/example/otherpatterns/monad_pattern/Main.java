package com.example.otherpatterns.monad_pattern;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        User user = new User("user", 24, Sex.M, "h@m.com");
        User validated = Validator.of(user).validate(User::getName, Objects::nonNull, "Name is null").validate(User::getName, name -> !name.isEmpty(), "name is empty")
                .validate(User::getAge, age -> age > 25, "age should greater than 25").get();
        
        
        
        Function<User,User> transformation = (u)-> new User(null, 0, null, null);
        Predicate<User> validationName = u-> u.getName() !=null;       
		Validator.of(user).validate(transformation, validationName, "name should not be null").get();
        
        
        
        System.out.println("");
    }
}
