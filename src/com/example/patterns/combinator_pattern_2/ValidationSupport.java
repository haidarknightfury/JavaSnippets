package com.example.patterns.combinator_pattern_2;

import java.util.Optional;

public class ValidationSupport {

    /**
     * Provide an implementation of the valid validation result
     */
    private static final ValidationResult valid = new ValidationResult() {

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    static ValidationResult valid() {
        return valid;
    }
}
