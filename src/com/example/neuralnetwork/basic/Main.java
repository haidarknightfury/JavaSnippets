package com.example.neuralnetwork.basic;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		// BASIC FORMULA : (a+b)*2
		List<Input>cases = new  ArrayList<>();
		cases.add(new Input(2.0, 3.0, 10.0));
		cases.add(new Input(1.0, 1.0, 4.0));
		cases.add(new Input(5.0, 2.0, 14.0));
		cases.add(new Input(12.0, 3.0, 30.0));
		
		
		Neuron neuron = new Neuron();
		neuron.setW1(1.0);
		neuron.setW2(1.0);
		
		
		for(int i=0;i<1000000;i++) {
			cases.stream().forEach(casex->{
				neuron.setNewValues(casex.I1, casex.I2, casex.O);
				neuron.adjustWeights();
			});
		}

		System.out.println(neuron.getW1());
		System.out.println(neuron.getW2());
	}
}
