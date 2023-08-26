package com.example.patterns.observer_pattern.pattern3;

import com.example.patterns.observer_pattern.pattern3.base.ISubscriber;

public class ChangeSubscriber implements ISubscriber<ChangeEvent> {

	@Override
	public void subscribe(ChangeEvent event, Request request) {
		System.out.println("A change happened");
	}

	public void registerWithObserver(ChangeObserver changeObserver) {
		changeObserver.registerSubscriber(this);
	}

}
