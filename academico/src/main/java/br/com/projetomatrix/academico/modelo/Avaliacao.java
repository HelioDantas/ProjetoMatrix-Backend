package br.com.projetomatrix.academico.modelo;

import java.math.BigDecimal;

import br.com.projetomatrix.academico.enumm.Modo;

public class Avaliacao {

	private String codigo;
	private String dataDeRealizacao;
	private String descricao;
	private BigDecimal nota;
	private Modo modo;
	private Aluno aluno;
	private Turma turma;
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

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
