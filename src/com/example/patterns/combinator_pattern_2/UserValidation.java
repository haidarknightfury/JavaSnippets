package com.example.patterns.combinator_pattern_2;

import static com.example.patterns.combinator_pattern_2.ValidationResult.invalid;
import static com.example.patterns.combinator_pattern_2.ValidationSupport.valid;

import java.util.function.Function;
import java.util.function.Predicate;

import com.example.patterns.combinator_pattern_1.User;

public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation nameIsNotEmpty() {
        return holds(user -> !user.name.trim().isEmpty(), "Name is Empty");
    }

    static UserValidation emailContainsAtSign() {
        return holds(user -> user.email.contains("@"), "Missing @");
    }

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? valid() : invalid(message);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

}
