package br.com.projetomatrix.academico.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Boletim {
	private Aluno aluno;
	private Turma turma;
	private ArrayList<Avaliacao> avaliacao;
	private BigDecimal media;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}



}
