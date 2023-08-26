package com.example.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;


public class Thing {
	
	  public @interface Dance {
          long rhythm() default 66;
          int[] value();
          String track() default "";
          final boolean fast = true;
       }


	int age;

	private Thing() {
		
		@Deprecated
		myenum e = myenum.BAKA;
		
		switch(e) {
		case BAKA:	
			
		}
	}
	
	public interface Baka{
		Number minaSa();
	}

	public static class A implements Baka {
		
		public int getInt() {
			long l = 23;
			return 1;
		}
		
		B getB() {
			return new B();
		}

		@Override
		public Integer minaSa() {
			return 5;
		}
	}

	public static class B extends A {
		
		public int getInt() {
			
			return 2;
		}
		
		@Override
		protected B getB() {
			return new C(); // covariant
		}
		
		@Override
		public Integer minaSa() {
			return 43;
		}
	}

	public static class C extends B {
	}

	public void check(int con, int val) {

	}

	public static void hellovararg(int x, int... y) {

	}
	

	

	public static void helloBool(Boolean bool) {
		System.out.println("that one");
	}
	
	

enum myenum {
	BAKA("fa"), OMAYWA("fafa");
	
	private String val;
	
	private String getVal() {
		return val;
	}
	
	private void setVal(String va) {
		this.val = va;
	}
	
	myenum(String val){
		this.val = val;
	}
}


	public static void main(String[] args) {
		Thing t = new Thing();
		System.out.println(new Thing().age);

		int var = 12;

		double bin = 0xE;
		System.out.println(bin);

		hellovararg(1, new int[] { 1, 2, 3 });

		int x = 1;
		short r = 10;
		double y = x;
		double z = r;
		
		
		helloBool(true);

		List<Integer> f = new ArrayList<>();
		f.add(1);
		f.add(2);

		ArrayList<Integer> s = new ArrayList();
		s.add(1);
		s.add(2);

		System.out.println(f.equals(s));

		String str = "abc";
		String str2 = new String("abc");
		System.out.println(str == str2);

		List<B> bList = new ArrayList<B>();
		// Any list extending A can be referenced
		List<? extends A> slist = bList; // upper bound card ?

		List<? super B> list = new ArrayList<>(); // lower bound card - any class which is a sub class of A can be added
		list.add(new B());
//		list.add(new A());
		list.add(new C());

		list = new ArrayList<A>();

//		
//		Stream<String> s = Stream.of("monkey", "ape", "bonobo");
//		Optional<String> min = s.min((Object s1, Object s2) -> ((String) s1).length()- ((String) s2).length());
//		min.ifPresent(System.out::println); // ape
//		
		
		
		A a = new A();
		B b = new B();
		
		System.out.println(a.getInt());
		System.out.println(b.getInt());
		
		
		myenum ca = myenum.BAKA;
		ca.setVal("mikasa");
		System.out.println(ca.getVal());
	}
}
