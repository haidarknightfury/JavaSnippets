package com.example.snippets.predicate.basic;

public class Example4 {

	public interface vehicle {

		default void print() {
			System.out.println("A Vehicle");
		}
	}

	public interface fourWheeler {
		default void print() {
			System.out.println("Four wheeler");
		}
	}

	public class Car implements vehicle, fourWheeler {
		@Override
		public void print() {
			fourWheeler.super.print();
		}
	}

	public static void main(String[] args) {
		Car car = new Example4().new Car();
		car.print();

	}

}
