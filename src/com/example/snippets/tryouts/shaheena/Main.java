package com.example.snippets.tryouts.shaheena;

public class Main {

	public static void main(String [] args) {
		Pebble pebble =new Pebble(0);
	
		PebbleResourceThread foolThread = new PebbleResourceThread("Fool", pebble, -5);
		PebbleResourceThread coolThread = new PebbleResourceThread("Cool", pebble, 5);
		PebbleResourceThread shinaThread = new  PebbleResourceThread("Shina", pebble, -4);
		
		coolThread.start();
		foolThread.start();
		shinaThread.start();
		
		/**
		 * Explanation
		 * 
		 * The 3 persons are represented by 3 threads and each sharing a common object Pebble
		 * which contains the total number of pebbles. The threads share a common space (pebble) where each thread operation
		 * either increments or decrements the number of pebbles 
		 * 
		 * Since the threads execution order is not controlled, there is a possibility that Shina's thread executes first
		 * Hence this would cause a -ve number of pebbles which is not possible in the real world. 
		 * 
		 * Hence due to this race condition, it is not appropriate to share and execute operations on common shared object.
		 * A producer consumer implementation will allow an effective distribution , and consumer threads will 'sleep' until the 
		 * producer threads produce the pebbles.
		 */
	}
}
