package com.example.controles;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ControlesClient controlesClient = new ControlesClient(new Toggle(true), "ha", "he");
		controlesClient.applyControle();
	}
	
}
