package com.example.patterns.observer_pattern.pattern3.base;

import java.util.ArrayList;
import java.util.List;

import com.example.patterns.observer_pattern.pattern3.Request;

public abstract class AbstractObserver<T extends ISubscriber<U>, U> {

	private List<T> subscribers = new ArrayList<>();

	public void registerSubscriber(T subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void notifySubscribers(U event, Request request) {
		this.subscribers.forEach(subscriber->{
			subscriber.subscribe(event, request);
		});
	}
}
