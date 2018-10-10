package com.example.krakathon.easy;

public class Divisible {
	
	public static int highest = 20;
	
	public static void main(String [] args) {
		
		int number = 1;
		boolean divisible = false;
		
		while(!divisible) {
			divisible = true;
			for(int i=1;i< highest;i++) {
				divisible = divisible && number% i ==0;
			}
			number++;
		}
		
		System.out.println(number-1);
		
		
	
	}

}
