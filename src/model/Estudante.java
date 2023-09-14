package model;

public class Estudante {
	
	private String nome;
	private Integer ID;
	private String curso;
	
	public Estudante() {
		
	}

	public Estudante(Integer id) {
		this.ID = id;
	}
	
	public Estudante(String nome, String curso) {
		super();
		this.nome = nome;
		this.curso = curso;
	}
	
	public Estudante(Integer iD, String nome, String curso) {
		this.nome = nome;
		ID = iD;
		this.curso = curso;
	}

	
	public Estudante(String cursoEditar) {
		this.curso = cursoEditar;
	}

	public String getNome() {
		return nome;
	}

	public Integer getID() {
		return ID;
	}

	public String getCurso() {
		return curso;
	}

	public String setNome(String nome) {
		return this.nome = nome;
	}
	
	//na duvida se irei excluir o setID, pois o id precisa ser unico, não editavel.
	public void setID(Integer id) {
		this.ID = id;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}
