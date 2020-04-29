package com.example.controles;

import java.util.Objects;

public interface Precondition {

	/**
	 * Evaluate the precondition
	 * @return
	 */
	Boolean test();
	
	default Precondition and(Precondition other) {
		Objects.requireNonNull(other);
		return () -> test() && other.test();
	}

	default Precondition negate() {
		return () -> !test();
	}

	
	default Precondition or (Precondition other) {
		Objects.requireNonNull(other);
		return ()-> test() || other.test();
	}
	
}
