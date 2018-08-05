package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ProfessorService {
	private int sequencial = 0;

	private Map<String, Professor> hashProfessor = new HashMap<>();

	public Professor cadastrarProfessor(Professor professor) {

		if (professor == null || hashProfessor.containsKey(professor.getMatricula()))
			return professor;

		professor.setMatricula(gerarMatricular(professor));
		return professor;
	}

	public Professor recuperarProfessor(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		return hashProfessor.get(matricula);
	}

	public void removerProfessor(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		hashProfessor.remove(matricula);
	}

	public void atualizarProfessor(Professor professor) {
		if (professor == null || professor.getMatricula() == null || professor.getMatricula().length() == 0)
			throw new IllegalArgumentException();

		removerProfessor(professor.getMatricula());
		cadastrarProfessor(professor);

	}

	private String gerarMatricular(Professor professor) {
		// TODO Auto-generated method stub
		int ano = LocalDateTime.now().getYear();
		String anoconvertido = Integer.toString(ano);
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		sequencial++;
		String StringSequencial = Integer.toString(sequencial);
		String matricula = anoconvertido + "." + semestre +"."+ StringSequencial;

		return matricula;
	}


}
