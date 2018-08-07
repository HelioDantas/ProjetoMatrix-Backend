package br.com.projetomatrix.academico.modelo;

import java.util.ArrayList;

public class Historico {
	
	private String matriculaDoAluno;
	private ArrayList<Boletim> boletim;
	public String getMatriculaDoAluno() {
		return matriculaDoAluno;
	}
	public void setMatriculaDoAluno(String matriculaDoAluno) {
		this.matriculaDoAluno = matriculaDoAluno;
	}
	public ArrayList<Boletim> getBoletim() {
		return boletim;
	}
	public void setBoletim(ArrayList<Boletim> boletim) {
		this.boletim = boletim;
	}
	

}
