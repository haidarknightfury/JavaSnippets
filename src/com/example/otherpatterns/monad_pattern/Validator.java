package com.example.otherpatterns.monad_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validator<T> {

	private final T t;
	private final List<Throwable> exceptions = new ArrayList<Throwable>();

	private Validator(T t) {
		this.t = t;
	}

	public static <T> Validator<T> of(T t) {
		return new Validator<T>(Objects.requireNonNull(t));
	}

	public T get() throws IllegalStateException {
		if (this.exceptions.isEmpty()) {
			return this.t;
		}
		IllegalStateException e = new IllegalStateException();
		this.exceptions.forEach(e::addSuppressed);
		throw e;
	}

	public <U> Validator<T> validate(Function<T, U> projection, Predicate<U> validation, String message) {
		return this.validate(projection.andThen(validation::test)::apply, message);
	}

	public Validator<T> validate(Predicate<T> validation, String message) {
		if (!validation.test(this.t)) {
			this.exceptions.add(new IllegalStateException(message));
		}
		return this;
	}

}
