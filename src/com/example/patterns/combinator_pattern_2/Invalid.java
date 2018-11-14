package com.example.patterns.combinator_pattern_2;

import java.util.Optional;

public class Invalid implements ValidationResult {

    private final String reason;

    public Invalid(String reason) {
        this.reason = reason;
    }

    public boolean isValid() {
        return false;
    }

    public Optional<String> getReason() {
        return Optional.of(this.reason);
    }

}
