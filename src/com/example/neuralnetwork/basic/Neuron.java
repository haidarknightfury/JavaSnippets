package com.example.neuralnetwork.basic;

public class Neuron {
	
	public static final double WEIGHT_ADJUSTMENT = 0.001;

	private Double input1;
	
	private Double	input2;
	
	private Double output;
	
	private Double realOutput;
	
	private Double w1;
	
	private Double w2;
	
	
	public void setNewValues(Double input1, Double input2,  Double realOutput) {
		this.input1 = input1;
		this.input2 = input2;
		this.realOutput = realOutput;
	}

	public Double getInput1() {
		return input1;
	}

	public void setInput1(Double input1) {
		this.input1 = input1;
	}

	public Double getInput2() {
		return input2;
	}

	public void setInput2(Double input2) {
		this.input2 = input2;
	}

	public Double getOutput() {
		return output;
	}

	public void setOutput(Double output) {
		this.output = output;
	}

	public Double getW1() {
		return w1;
	}

	public void setW1(Double w1) {
		this.w1 = w1;
	}

	public Double getW2() {
		return w2;
	}

	public void setW2(Double w2) {
		this.w2 = w2;
	}
	
	public void calculateOutput() {
		this.output = this.input1* this.w1 + this.input2* this.w2;
	}
	
	public Double calculateDifference() {
		return this.realOutput - this.output;
	}
	
	public void adjustWeights() {
		calculateOutput();
		Double weightDiff = calculateDifference();
		this.w1 = this.w1 + weightDiff * this.input1 * WEIGHT_ADJUSTMENT;
		this.w2 = this.w2 + weightDiff * this.input2 * WEIGHT_ADJUSTMENT;
	}
	
	
	

}
