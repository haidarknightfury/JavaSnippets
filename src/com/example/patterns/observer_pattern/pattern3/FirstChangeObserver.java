package com.example.patterns.observer_pattern.pattern3;

import com.example.patterns.observer_pattern.pattern3.base.ObserverManager;

public class FirstChangeObserver extends ChangeObserver {

	public FirstChangeObserver(ObserverManager observerManager) {
		super(observerManager);
	}

	@Override
	public void detectChange(Request oldRequest, Request newRequest, ChangeEvent event, Request request) {
		if (oldRequest != newRequest) {
			this.notifySubscribers(event, request);
		}
	}

}
