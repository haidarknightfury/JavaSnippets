package com.example.patterns.observer_pattern.pattern3.base;

import com.example.patterns.observer_pattern.pattern3.Request;

/**
 * Subscriber - override subscribe method to handle a generic event
 * @author Haidar
 * @param <T>
 */

public interface ISubscriber<T> {
	
	public void subscribe(T event, Request request);
	
}
