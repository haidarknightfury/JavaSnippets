package com.example.controles;

import java.util.Arrays;
import java.util.Objects;

public class ControlesClient extends Controle {

	private String variable1;
	private String variable2;
	private Controle controleVariable1;
	private Controle controleVariable2;

	private Controle controleVariable2Longueure;

	public ControlesClient(Toggle toggle, String variable1, String variable2) {
		super(toggle);
		this.variable1 = variable1;
		this.variable2 = variable2;
		controleVariable1 = createControleVariable1(variable1);
		controleVariable2 = createControleVariable2(variable1, variable2);
		controleVariable2Longueure = new ControleComplexLongueur(new Toggle(true), variable2);
	}

	@Override
	public void controle() throws Exception {
		controleVariable1.applyControle();
		controleVariable2.applyControle();
		
		Precondition controleVariable2Precondition1 = ()-> null!=variable2;
		Precondition controleVariable2Precondition2 = () -> null!= variable1;
		
		
		controleVariable2Longueure.addPrecondition(controleVariable2Precondition1);
		controleVariable2Longueure.addPrecondition(controleVariable2Precondition2);
		
		controleVariable2Longueure.applyControle();
	}
	
	
	private Controle createControleVariable1(String variable1) {
		final Controle controleVariable1 = new Controle(new Toggle(true)) {

			@Override
			public void controle() throws Exception {
				Objects.requireNonNull(variable1, "variable 1 cannot be null");
			}
		};
		return controleVariable1;
	}
	
	
	public static Controle createControleVariable2(String variable1, String variable2) {
		 return new Controle(new Toggle(true), Arrays.asList(() -> null != variable1)) {

				@Override
				public void controle() throws Exception {
					Objects.requireNonNull(variable2, "variable 2 cannot be null");
				}
			};
	}
}
