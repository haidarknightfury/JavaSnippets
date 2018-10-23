package com.example.krakathon.easy;

import java.math.BigInteger;
import java.util.Scanner;

public class MachineNumberGuesser {
	

	public static void main(String [] args) {
			
		    BigInteger MAX  = new BigInteger("100000000000000");
			BigInteger MIN = new BigInteger("0");
		
			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER YOUR NUMBER : ");
			BigInteger entered = new BigInteger(sc.next());
			
			
			BigInteger machineInput = MAX.divide(BigInteger.valueOf(2));
			String operation;
			while(!machineInput.equals(entered)) {
					System.out.println("GENERATED NUMBER: " + machineInput);
				
					operation = sc.next();
					if(operation.equals("<")) {
						   MIN  = machineInput;
						   machineInput = machineInput.add((MAX.subtract(MIN)).divide(BigInteger.valueOf(2)));
						
					}
					else if(operation.equals(">")) {
						    MAX = machineInput;
							machineInput =  (MAX.add(MIN)).divide(BigInteger.valueOf(2));	
					}
					System.out.println("MIN"+ MIN);
					System.out.println("MAX"+ MAX);
				
			}
			
			System.out.println("NUMBER FOUND" + machineInput);
			
			
			
			
			sc.close();
			
		
		
	}

}
