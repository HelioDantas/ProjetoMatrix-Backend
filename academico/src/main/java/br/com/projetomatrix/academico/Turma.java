package br.com.projetomatrix.academico;

import java.util.ArrayList;

public class Turma {
	private String codigo;
	private String anoLetivo;
	private String semestre;
	private String dataDeAbertura;
	private String dataDeEncerramento;
	private Diciplina diciplina;
	private Professor professor;
	private  ArrayList<Aluno> aluno;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getDataDeAbertura() {
		return dataDeAbertura;
	}
	public void setDataDeAbertura(String dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	public String getDataDeEncerramento() {
		return dataDeEncerramento;
	}
	public void setDataDeEncerramento(String dataDeEncerramento) {
		this.dataDeEncerramento = dataDeEncerramento;
	}
	public Diciplina getDiciplina() {
		return diciplina;
	}
	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public ArrayList<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(ArrayList<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	
	
}
