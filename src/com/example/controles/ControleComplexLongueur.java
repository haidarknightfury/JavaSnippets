package com.example.controles;

public class ControleComplexLongueur extends Controle {

	private String variable2;
	
	public ControleComplexLongueur(Toggle toggle, String variable2) {
		super(toggle);
		this.variable2 = variable2;
	}
	
	@Override
	public void controle() throws Exception {
		if (variable2.length() < 3) {
			throw new Exception("Length of variable 2 should not be less than 3");
		}
	}

}
