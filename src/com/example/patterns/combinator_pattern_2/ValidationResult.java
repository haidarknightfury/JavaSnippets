package com.example.patterns.combinator_pattern_2;

import java.util.Optional;

/**
 * Only 2 validation results are plausible
 * valid and invalid
 *
 * @author hdargaye
 *
 */
public interface ValidationResult {

    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult invalid(String reason) {
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();
}
