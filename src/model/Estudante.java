package model;

public class Estudante {
	
	private String nome;
	private Integer ID;
	private String curso;
	
	public Estudante() {
		
	}

	public Estudante(Integer iD, String nome, String curso) {
		super();
		this.nome = nome;
		ID = iD;
		this.curso = curso;
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//na duvida se irei excluir o setID, pois o id precisa ser unico, não editavel.
	public void setID(Integer iD) {
		this.ID = iD;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}
