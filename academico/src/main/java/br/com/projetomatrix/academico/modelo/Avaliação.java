package br.com.projetomatrix.academico.modelo;

import br.com.projetomatrix.academico.enumm.Modo;

public class Avaliação {

	private String codigo;
	private String dataDeRealizacao;
	private String descricao;
	private Modo modo;
	private Aluno aluno;
	private Professor professor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDataDeRealizacao() {
		return dataDeRealizacao;
	}

	public void setDataDeRealizacao(String dataDeRealizacao) {
		this.dataDeRealizacao = dataDeRealizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Modo getModo() {
		return modo;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
