package com.example.snippets.collections.basic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import com.example.snippets.reflection.basic.Ligurio;
import com.example.snippets.reflection.basic.Olive;
import com.example.snippets.reflection.basic.Picholine;

public class Example1 {

	public static void main(String[] args) {

		// Hashset - each item appears once
		// Hashset is faster - but not in order
		HashSet<String> set = new HashSet<>();
		set.add("abc");
		set.add("def");
		set.add("abc");
		System.out.println("Set size :" + set.size());
		set.remove("def");
		System.out.println("Set size :" + set.size());

		// Treeset - keep in an order that can be controlled
		// Object must implement comparable
		TreeSet<Olive> treeSet = new TreeSet<>();
		treeSet.add(new Picholine("", ""));
		treeSet.add(new Ligurio("", ""));
		System.out.println(treeSet);

		// LinkedList
		LinkedList<Olive> list = new LinkedList<>();
		list.add(new Picholine("", ""));
		list.add(new Ligurio("", ""));
		display(list);

		System.out.println(list.peek().toString());
		// remove from list
		System.out.println(list.poll());
		display(list);

	}

	public static void display(Collection<Olive> col) {
		System.out.println("list order : ");
		Iterator<Olive> iter = col.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}

}
