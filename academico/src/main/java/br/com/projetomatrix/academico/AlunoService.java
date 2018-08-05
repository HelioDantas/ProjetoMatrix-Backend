package br.com.projetomatrix.academico;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AlunoService {
	private int sequencial = 0;

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

	public void atualizarAlunos(Aluno alunonovo) {
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
		sequencial++;
		String StringSequencial = Integer.toString(sequencial);
		String matricula = anoconvertido + "." + semestre +"."+ StringSequencial;

		return matricula;
	}

	
	public Status BuscaStatusDoAluno(String matricula) {
		Aluno aluno = recuperarAluno(matricula);

		return aluno.getStatus();
	}
}