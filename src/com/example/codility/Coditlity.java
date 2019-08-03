package com.example.codility;

import java.util.*;
import java.util.stream.Stream;

public class Coditlity {
	public static int solution(int[] A) {
		List<Integer> list = new ArrayList<>();
	    for (int x: A) {
	    	list.add(x);
	    }
	    Collections.sort(list);
	    for(int i=1;i<list.size();i++) {
	    	if(list.get(i) - list.get(i-1) > 1) {
	    		return list.get(i)-1;
	    	}
	    }
		return 0;
	}

	public static void main(String[] args) {
	   int s =  solution(new int[] {1,2,4,5});
	   System.out.println(s);
	}

}
