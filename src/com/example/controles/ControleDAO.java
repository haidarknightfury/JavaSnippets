package com.example.controles;

import java.util.List;

public abstract class ControleDAO extends Controle {

	//Autowired
	private final Repository tControleRepository;
	private final String code;
	
	public ControleDAO(Repository repository, String code, List<Precondition> preconditions) {
		super(preconditions);
		this.code = code;
		this.tControleRepository = repository;
	}
	
	public ControleDAO(Repository repository, String code) {
		this.code = code;
		this.tControleRepository = repository;
	}
	
	@Override
	public void applyControle() throws Exception{
		setToggle(tControleRepository.findByCode(code));
		super.applyControle();
	}
	


	

}
