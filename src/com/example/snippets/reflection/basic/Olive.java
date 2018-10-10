package com.example.snippets.reflection.basic;

public class Olive implements Comparable<Olive> {

	private String name;
	private String colour;

	public Olive(String name, String colour) {
		this.setName(name);
		this.setColour(colour);
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Olive [name=" + name + ", colour=" + colour + "]";
	}

	@Override
	public int compareTo(Olive o) {
		String s1 = this.getClass().getSimpleName();
		String s2 = o.getClass().getSimpleName();
		return s1.compareTo(s2);
	}

}
