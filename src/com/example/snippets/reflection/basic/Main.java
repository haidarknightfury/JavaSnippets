package com.example.snippets.reflection.basic;

import java.lang.reflect.Constructor;

public class Main {

	public static void main(String[] args) {

		Olive olive = new Olive("vera", "green");
		Class<?> c = olive.getClass();

		System.out.println(c.getName());
		System.out.println(c.getSimpleName());

		Constructor<?>[] constructors = c.getConstructors();
		System.out.println("Num constructors " + constructors.length);

		// only one constructor in class
		Constructor<?> con = constructors[0];

		Object obj = null;
		try {
			// must wrap inside try catch
			// argument type mismatch if not same type of constructor
			obj = con.newInstance("OliveName", "Green");
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Reflection - walking in inheritance tree
		// walk up inheritance tree, not down

		Object o = new Ligurio("name", "color");
		Class<?> co = o.getClass();

		System.err.println("Class Name" + co.getName());

		Class<?> sup = co.getSuperclass();
		System.out.println("Super Name" + sup.getName());

		Class<?> base = sup.getSuperclass();
		System.out.println("Top" + base.getName());

		Package p = co.getPackage();
		System.out.println("Package" + p.getName());

	}

}
