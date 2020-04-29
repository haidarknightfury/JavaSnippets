package com.example.controles;

import java.util.List;

public abstract class ControleDAO extends Controle {

	//Autowired
	private final Repository repository;
	private final String code;
	
	public ControleDAO(Repository repository, String code, List<Precondition> preconditions) {
		super(preconditions);
		this.code = code;
		this.repository = repository;
	}
	
	public ControleDAO(Repository repository, String code) {
		this.code = code;
		this.repository = repository;
	}
	
	@Override
	public void applyControle() throws Exception{
		setToggle(repository.findByCode(code));
		super.applyControle();
	}
	
	@Override
	public abstract void controle() throws Exception;

}
