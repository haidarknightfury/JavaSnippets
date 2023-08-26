package com.example.patterns.observer_pattern.pattern3;

import com.example.patterns.observer_pattern.pattern3.base.AbstractObserver;
import com.example.patterns.observer_pattern.pattern3.base.ISubscriber;
import com.example.patterns.observer_pattern.pattern3.base.ObserverManager;

public abstract class ChangeObserver extends AbstractObserver<ISubscriber<ChangeEvent>, ChangeEvent>{
	

	public ChangeObserver(ObserverManager observerManager) {
			observerManager.registerChangeEventObserver(this);
	}

	public abstract void detectChange(Request oldRequest, Request newRequest, ChangeEvent event, Request request);

}
