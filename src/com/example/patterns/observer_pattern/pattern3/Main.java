package com.example.patterns.observer_pattern.pattern3;

import com.example.patterns.observer_pattern.pattern3.base.ObserverManager;

public class Main {

	public static void main(String[] args) {
		ObserverManager observerManager = new ObserverManager();
		FirstChangeObserver firstChangeObserver = new FirstChangeObserver(observerManager);
		SecondChangeObserver secondChangeObserver = new SecondChangeObserver(observerManager);
		
		ChangeSubscriber changeSubscriber = new ChangeSubscriber();
		changeSubscriber.registerWithObserver(firstChangeObserver);
		changeSubscriber.registerWithObserver(secondChangeObserver);
		
		observerManager.applicationUpdate(new Request(), new Request(), new ChangeEvent(), new Request());
		
	}
}
