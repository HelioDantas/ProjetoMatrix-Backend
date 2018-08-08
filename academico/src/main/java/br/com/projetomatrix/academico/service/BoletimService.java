package br.com.projetomatrix.academico.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.projetomatrix.academico.modelo.Aluno;
import br.com.projetomatrix.academico.modelo.Avaliacao;
import br.com.projetomatrix.academico.modelo.Boletim;
import br.com.projetomatrix.academico.modelo.Turma;

public class BoletimService {
	
	public Boletim criarBoletim(Aluno aluno, Turma turma, ArrayList<Avaliacao> avaliacoes) {
		Boletim boletim = new Boletim();
		boletim.setAluno(aluno);
		boletim.setTurma(turma);
		boletim.setAvaliacao(avaliacoes);
		boletim.setMedia(media(avaliacoes));
		return boletim;
		
	}
	
	
	
	
	public BigDecimal media(ArrayList<Avaliacao> avaliacao) {
		BigDecimal soma = new BigDecimal("0");
		 for (Avaliacao avaliacao2 : avaliacao) {
			 soma = soma.add(avaliacao2.getNota());	 
			
		}
		BigDecimal media = soma.divide(new BigDecimal("3"), 2, BigDecimal.ROUND_HALF_UP);
		 return media;
	}

}
