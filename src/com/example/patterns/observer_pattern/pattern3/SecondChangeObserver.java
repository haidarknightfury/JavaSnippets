package com.example.patterns.observer_pattern.pattern3;

import com.example.patterns.observer_pattern.pattern3.base.ObserverManager;

public class SecondChangeObserver extends ChangeObserver {

	public SecondChangeObserver(ObserverManager observerManager) {
		super(observerManager);
	}

	@Override
	public void detectChange(Request oldRequest, Request newRequest, ChangeEvent event, Request request) {
		if (oldRequest != newRequest) {
			this.notifySubscribers(event, request);
		}
	}

}
