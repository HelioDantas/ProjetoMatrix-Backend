package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SistemaAcademicoService {
	private Long sequencial = new Long(0);

	private Map<String, Aluno> hashAlunos = new HashMap<>();

	public Aluno cadastrarAluno(Aluno aluno) {

		if (aluno == null || hashAlunos.containsKey(aluno.getMatricula()))
			return aluno;

		aluno.setMatricula(gerarMatricular(aluno));
		return aluno;
	}

	public Aluno recuperarAluno(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		return hashAlunos.get(matricula);
	}

	public void removerAluno(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		hashAlunos.remove(matricula);
	}

	public void atualizarAluno(Aluno alunonovo) {
		if (alunonovo == null || alunonovo.getMatricula() == null || alunonovo.getMatricula().length() == 0)
			throw new IllegalArgumentException();

		removerAluno(alunonovo.getMatricula());
		cadastrarAluno(alunonovo);

	}

	private String gerarMatricular(Aluno aluno) {
		// TODO Auto-generated method stub
		int ano = LocalDateTime.now().getYear();
		String anoconvertido = Integer.toString(ano);
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";

		sequencial.sum(sequencial, 1);
		String matricula = anoconvertido + "." + semestre + sequencial;

		return matricula;
	}

}