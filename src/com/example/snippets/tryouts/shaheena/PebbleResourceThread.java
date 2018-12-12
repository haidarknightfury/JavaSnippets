package com.example.snippets.tryouts.shaheena;

public class PebbleResourceThread extends Thread{

	private String threadName;
	private Pebble pebble;
	private int number;

	public PebbleResourceThread(String name, Pebble pebble, int number) {
		super();
		this.threadName = name;
		this.pebble = pebble;
		this.number = number;
	}

	@Override
	public void run() {
		synchronized (this.pebble) {
			System.out.println(threadName +" Executing " + number +" Pebbles");
			System.out.println("Number of pebbles :"+ this.pebble.getPebbles());
			this.pebble.pebbleOperation(number);
		}
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public Pebble getPebble() {
		return pebble;
	}

	public void setPebble(Pebble pebble) {
		this.pebble = pebble;
	}
}
