package com.example.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Cat extends Animal {
	
	public interface CanMiaw {
		static public int x =3;
		abstract boolean miaou();
	}
	
	Predicate<Integer> i;
	
	
	interface Walk { public List move(); }
	interface Run extends Walk { public ArrayList move(); }
	
	final class Baka implements Walk {
		


		@Override
		public ArrayList move() {
			try {
				
				Predicate<Integer> isEven = i -> i % 2 == 0;
				
			} catch (ClassCastException e) {
				// TODO: handle exception
			}
			return null;
		}
		
	}
	

	
	private Integer legs;
	public static String age;
	
	public Cat() {
		super("","");
	}
	
	public Cat(String name, String category, Integer legs) {
		super(name, category);
		this.legs = legs;
	}

	public Integer getLegs() throws NullPointerException {
		return legs;
	}
	
	
	public static void main(String [] args) {
		Cat an = new Cat("", "", 2);
		Boolean isType = an instanceof CanMiaw;
		
		List<Animal> anims = new ArrayList<>();
		anims.add(an);
	}

}
