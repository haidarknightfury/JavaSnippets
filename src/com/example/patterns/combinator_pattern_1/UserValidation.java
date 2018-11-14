package com.example.patterns.combinator_pattern_1;

import java.util.function.Function;

/**
 * Extends User (takes as input a user)
 * Returns a Boolean
 * 
 * @author hdargaye
 *
 */
public interface UserValidation extends Function<User, Boolean> {

    static UserValidation nameNotEmpty() {
        return user -> !user.name.trim().isEmpty();
    }

    static UserValidation emailContainsAt() {
        return user -> user.email.contains("@");
    }

    default UserValidation and(UserValidation other) {
        return user -> this.apply(user) && other.apply(user);
    }
}
