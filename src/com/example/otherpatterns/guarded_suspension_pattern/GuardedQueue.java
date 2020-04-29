package com.example.otherpatterns.guarded_suspension_pattern;

import java.util.LinkedList;
import java.util.Queue;

public class GuardedQueue {

	private final Queue<Integer> sourceList;

	public GuardedQueue() {
		this.sourceList = new LinkedList<>();
	}

	public synchronized Integer get() {
		while (this.sourceList.isEmpty()) {
			try {
				System.out.println("waiting");
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("getting object");
		return this.sourceList.peek();
	}

	public synchronized void put(Integer e) {
		System.out.println("adding object");
		this.sourceList.add(e);
		System.out.println("notifying");
		this.notify();
	}
}
