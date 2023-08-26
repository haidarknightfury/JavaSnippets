package com.example.patterns.observer_pattern.pattern3.base;

import java.util.ArrayList;
import java.util.List;

import com.example.patterns.observer_pattern.pattern3.ChangeEvent;
import com.example.patterns.observer_pattern.pattern3.ChangeObserver;
import com.example.patterns.observer_pattern.pattern3.Request;

public class ObserverManager {
	
	List<ChangeObserver> changeObservers = new ArrayList<ChangeObserver>();

	public void registerChangeEventObserver(ChangeObserver changeObserver) {
		this.changeObservers.add(changeObserver);
	}
	
	public void applicationUpdate(Request oldRequest, Request newRequest, ChangeEvent changeEvent, Request request) {
		this.changeObservers.forEach(changeObserver->{
			changeObserver.detectChange(oldRequest, newRequest, changeEvent, request);
		});
	}

}
