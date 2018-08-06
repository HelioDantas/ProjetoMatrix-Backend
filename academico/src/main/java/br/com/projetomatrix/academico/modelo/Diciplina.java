package br.com.projetomatrix.academico.modelo;

import java.util.ArrayList;

public class Diciplina {

	private String descricao;
	private String codigo;
	private ArrayList<Diciplina> prerequisito;
	private Curso curso;

	private ArrayList<Professor> professor;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(ArrayList<Professor> professor) {
		this.professor = professor;
	}

	public ArrayList<Diciplina> getPrerequisito() {
		return prerequisito;
	}

	public void setPrerequisito(ArrayList<Diciplina> prerequisito) {
		this.prerequisito = prerequisito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
