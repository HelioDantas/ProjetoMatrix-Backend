package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;

public class SistemaAcademicoService {

	private AlunoService aluno3 = new AlunoService();
	private CursoService cursoService = new CursoService();
	private Tumaservice turmaService = new Tumaservice();

	public Aluno criarAluno(String nome) {
		Aluno novoAluno = new Aluno();
		novoAluno.setName(nome);
		aluno3.cadastrarAluno(novoAluno);
		return novoAluno;

	}



	public void CadastrarAlunoEmCurso(Aluno aluno, String codigoDoCurso) {

		try {
			Curso curso = cursoService.recuperarCurso(codigoDoCurso);
			aluno.setCurso(curso);

		} catch (Exception e) {
			System.out.println("erro: " + e);
		}

	}

	public boolean CadastrarAlunoEmTurma(Aluno aluno, String codigoDoTurma) {

		try {
			Turma turma = turmaService.recuperarTurma(codigoDoTurma);
			HashMap<String, Aluno> alunos = turma.getAlunos();

			if (alunos.containsKey(aluno.getMatricula()))
				throw new IllegalArgumentException();
			ArrayList<Turma> turmasEmQueOAlunoEstá = turmaService.BuscarTurmasDoAluno(aluno.getMatricula());
			if (turmaService.DisponibilidadeDeTurma(turma, turmasEmQueOAlunoEstá)) {

				alunos.put(aluno.getMatricula(), aluno);
				turma.setAlunos(alunos);
				turmaService.atualizarTurma(turma);

				return true;
			} else
				return false;

		} catch (Exception e) {
			return false;
		}

	}

}