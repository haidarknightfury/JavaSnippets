package com.example.snippets.tryouts.shaheena;

public class Pebble {
	
	private int pebbles;
	
	public Pebble(int pebbles) {
		this.setPebbles(pebbles);
	}
	
	public void pebbleOperation(int pebble) {
		this.setPebbles(this.getPebbles() + pebble);
	}

	public int getPebbles() {
		return pebbles;
	}

	public void setPebbles(int pebbles) {
		this.pebbles = pebbles;
	}

}
