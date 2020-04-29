package com.example.controles;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Controle de donnes
 * @author Haidar
 *
 */
public abstract class Controle implements iControle {
	
	private List<Precondition> preconditions = new ArrayList<Precondition>();
	private static final Predicate<Toggle> switchToggle = (tg) -> tg.getEnabled();
	private Toggle toggle = new Toggle(true);
	
	public Controle(Toggle toggle) { // not toggle but boolean
		this.setToggle(toggle);
	}
	
	public Controle(List<Precondition> preconditions) {
		super();
		this.preconditions = preconditions;
	}
	
	public Controle(Toggle toggle, List<Precondition> preconditions) {
		super();
		this.preconditions = preconditions;
		this.setToggle(toggle);
	}
	
	public Controle() {super();}
	

	@Override
	public abstract void controle() throws Exception;
	
	private Boolean reduce() {
	   Precondition reducedPrecondition =	preconditions.stream().reduce(()-> true, (f,s)-> f.and(s));
	   return reducedPrecondition.test();
	}
	
	public void applyControle() throws Exception{
		if(switchToggle.test(this.getToggle()) && reduce()) {
			controle();
		}
	}
	
	public void addPrecondition(Precondition precondition) {
		preconditions.add(precondition);
	}

	public Toggle getToggle() {
		return toggle;
	}

	public void setToggle(Toggle toggle) {
		this.toggle = toggle;
	}

}
