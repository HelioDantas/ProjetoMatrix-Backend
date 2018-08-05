package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tumaservice {
	private int sequencial = 0;

	private Map<String, Turma> hashTurmas = new HashMap<>();

	public Turma cadastrarTurma(Turma turma) {

		if (turma == null || hashTurmas.containsKey(turma.getCodigo()))
			throw new IllegalArgumentException();

		turma.setCodigo(gerarCodigo());
		return turma;
	}

	public Turma recuperarTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashTurmas.get(codigo);
	}

	public void removerTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashTurmas.remove(codigo);
	}

	public void atualizarTurma(Turma turma) {
		if (turma == null || turma.getCodigo() == null || turma.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerTurma(turma.getCodigo());
		cadastrarTurma(turma);

	}

	public ArrayList<Turma> BuscarTurmasDoProfessor(String matricula) {
		ArrayList<Turma> turmasDoProfessor = new ArrayList<>();
		for (String keyy : hashTurmas.keySet()) {
			Turma turma = hashTurmas.get(keyy);
			if (turma.getProfessor().getMatricula() == matricula)
				turmasDoProfessor.add(turma);

		}

		return turmasDoProfessor;

	}

	public ArrayList<Turma> BuscarTurmasDoAluno(String matricula) {
		ArrayList<Turma> turmasDoAluno = new ArrayList<>();
		for (String keyy : hashTurmas.keySet()) {
			Turma turma = hashTurmas.get(keyy);
			if (turma.getAlunos().containsKey(matricula))
				turmasDoAluno.add(turma);

		}

		return turmasDoAluno;

	}

	public boolean DisponibilidadeDeTurma(Turma turma, ArrayList<Turma> turmas) {

		for (Turma turma2 : turmas) {
			if (turma2.getHorario().getDiaDaSemana() == turma.getHorario().getDiaDaSemana())
				return false;
			else if (turma2.getHorario().getHorarioDeInicio() == turma.getHorario().getHorarioDeInicio())
				return false;

		}
		return true;

	}

	public String gerarCodigo() {
		sequencial++;

		return Integer.toString(sequencial);
	}

	// public Turma AdicionarAlunoNaTurma(Aluno aluno String turma) {

	// }

}
