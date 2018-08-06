package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.projetomatrix.academico.enumm.Status;
import br.com.projetomatrix.academico.modelo.Aluno;
import br.com.projetomatrix.academico.modelo.Curso;
import br.com.projetomatrix.academico.modelo.Professor;
import br.com.projetomatrix.academico.modelo.Turma;
import br.com.projetomatrix.academico.service.AlunoService;
import br.com.projetomatrix.academico.service.CursoService;
import br.com.projetomatrix.academico.service.ProfessorService;
import br.com.projetomatrix.academico.service.Tumaservice;

public class SistemaAcademicoService {

	private AlunoService aluno3 = new AlunoService();
	private CursoService cursoService = new CursoService();
	private Tumaservice turmaService = new Tumaservice();
	private ProfessorService professorservice = new ProfessorService();

	public Status buscaStatusDoAluno(Aluno aluno) {

		return aluno3.buscaStatusDoAluno(aluno.getMatricula());

	}

	public void removerAluno(Aluno aluno) {

		aluno3.removerAluno(aluno.getMatricula());

	}

	public Aluno recuperarAluno(Aluno aluno) {

		return aluno3.recuperarAluno(aluno.getMatricula());

	}

	public void atualizarAluno(Aluno aluno) {

		aluno3.atualizarAlunos(aluno);

	}

	public Aluno cadastrarAluno(Aluno aluno) {

		return aluno3.cadastrarAluno(aluno);

	}

	public Aluno criarAluno(String nome) {
		Aluno novoAluno = new Aluno();
		novoAluno.setName(nome);
		aluno3.cadastrarAluno(novoAluno);
		return novoAluno;

	}

	public Turma cadastrarTurma(Turma turma) {

		return turmaService.cadastrarTurma(turma);
	}

	public Turma recuperarTurma(String codigo) {

		return turmaService.recuperarTurma(codigo);
	}

	public void removerTurma(String codigo) {

		turmaService.recuperarTurma(codigo);
	}

	public void atualizarTurma(Turma turma) {

		turmaService.atualizarTurma(turma);

	}

	public void cadastrarAlunoEmCurso(Aluno aluno, String codigoDoCurso) {

		try {
			Curso curso = cursoService.recuperarCurso(codigoDoCurso);
			aluno.setCurso(curso);

		} catch (Exception e) {
			System.out.println("erro: " + e);
		}

	}

	public Professor cadastrarProfessor(Professor professor) {

		return professorservice.cadastrarProfessor(professor);
	}

	public Professor recuperarProfessor(String matricula) {

		return professorservice.recuperarProfessor(matricula);
	}

	public void removerProfessor(String matricula) {
		professorservice.removerProfessor(matricula);
	}

	public void atualizarProfessor(Professor professor) {
		professorservice.atualizarProfessor(professor);

	}

	public boolean cadastrarAlunoEmTurma(Aluno aluno, String codigoDoTurma) {

		try {
			Turma turma = turmaService.recuperarTurma(codigoDoTurma);
			HashMap<String, Aluno> alunos = turma.getAlunos();
			if (alunos.containsKey(aluno.getMatricula()))
				throw new IllegalArgumentException();
		//	System.out.println(aluno.getMatricula());

			ArrayList<Turma> turmasEmQueOAlunoEstá = turmaService.BuscarTurmasDoAluno(aluno.getMatricula());
			if (!turmaService.DisponibilidadeDeTurma(turma, turmasEmQueOAlunoEstá)) {

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

	public ArrayList<Turma> BuscarTurmasDoProfessor(String matricula) {

		return turmaService.BuscarTurmasDoProfessor(matricula);

	}

	public ArrayList<Turma> BuscarTurmasDoAluno(String matricula) {

		return turmaService.BuscarTurmasDoAluno(matricula);
	}

	public boolean DisponibilidadeDeTurma(Turma turma, ArrayList<Turma> turmas) {

		return turmaService.DisponibilidadeDeTurma(turma, turmas);

	}

}