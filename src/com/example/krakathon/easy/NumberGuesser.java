package com.example.krakathon.easy;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
		private static final int MAX = 100;
	
		public static void main(String [] args) {
			
			Random rn = new Random();
			int randomNum = rn.nextInt(MAX + 1);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER A NUMBER");
			int enteredNumber = sc.nextInt();
			
			while(enteredNumber != randomNum) {
				if(enteredNumber < randomNum) {
					System.out.println("Your Number is lesser");
				}
				else if( enteredNumber> randomNum) {
					System.out.println("Your number is greater");
				}
				System.out.println("ENTER NEXT NUMBER");
				enteredNumber = sc.nextInt();
			}
			
			System.out.println("CONGRATS YOU WIN");
			sc.close();
		}
}
