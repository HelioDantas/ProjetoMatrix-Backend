package br.com.projetomatrix.academico.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.projetomatrix.academico.enumm.Status;
import br.com.projetomatrix.academico.enumm.StatusAcademico;
import br.com.projetomatrix.academico.modelo.Aluno;
import br.com.projetomatrix.academico.modelo.Avaliacao;
import br.com.projetomatrix.academico.modelo.Boletim;
import br.com.projetomatrix.academico.modelo.Curso;
import br.com.projetomatrix.academico.modelo.Historico;
import br.com.projetomatrix.academico.modelo.Professor;
import br.com.projetomatrix.academico.modelo.Turma;

public class SistemaAcademicoService {

	private AlunoService aluno3 = new AlunoService();
	private CursoService cursoService = new CursoService();
	private Tumaservice turmaService = new Tumaservice();
	private ProfessorService professorservice = new ProfessorService();
	private AvaliacaoService avalicaoService = new AvaliacaoService();
	private BoletimService boletimService = new BoletimService();
	private HistoricoService historicoService = new HistoricoService();

	public Status buscaStatusDoAluno(Aluno aluno) {

		return aluno3.buscaStatusDoAluno(aluno.getMatricula());

	}

	public void removerAluno(Aluno aluno) {

		aluno3.removerAluno(aluno.getMatricula());

	}

	public Aluno recuperarAluno(String matricula) {

		return aluno3.recuperarAluno(matricula);

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

	public void removerAvaliacao(Avaliacao avaliacao) {

		avalicaoService.removerAvalicao(avaliacao.getCodigo());

	}

	public Avaliacao recuperarAvaliacao(String matricula) {

		return avalicaoService.recuperarAvalicao(matricula);

	}

	public void atualizarAvaliacao(Avaliacao avaliacao) {

		avalicaoService.atualizarAvalicao(avaliacao);

	}

	public Avaliacao cadastrarrAvaliacao(Avaliacao avaliacao) {

		return avalicaoService.cadastrarAvalicao(avaliacao);

	}

	public Boletim criarBotetim(String matricula, String codigoDaTurma) {
		ArrayList<Avaliacao> avaliacoes = buscarAvaliacoesDoAlunoNaTurma(matricula + codigoDaTurma);
		Aluno aluno = recuperarAluno(matricula);
		Turma turma = recuperarTurma(codigoDaTurma);

		return boletimService.criarBoletim(aluno, turma, avaliacoes);

	}

	public void cadastrarAlunoEmCurso(Aluno aluno, String codigoDoCurso) {

		try {
			Curso curso = cursoService.recuperarCurso(codigoDoCurso);
			aluno.setCurso(curso);

		} catch (Exception e) {
			System.out.println("erro: " + e);
		}

	}

	public boolean cadastrarAlunoEmTurma(Aluno aluno, String codigoDoTurma) {

		try {
			Turma turma = turmaService.recuperarTurma(codigoDoTurma);
			HashMap<String, Aluno> alunos = turma.getAlunos();
			if (alunos != null)
				if (alunos.containsKey(aluno.getMatricula()))
					throw new IllegalArgumentException();

			ArrayList<Turma> turmasEmQueOAlunoEstá = turmaService.BuscarTurmasDoAluno(aluno.getMatricula());
			if (turmaService.DisponibilidadeDeTurma(turma, turmasEmQueOAlunoEstá)) {
				alunos.put(aluno.getMatricula(), aluno);
				turma.setAlunos(alunos);
				atualizarTurma(turma);

				return true;
			} else
				return false;

		} catch (Exception e) {
			return false;
		}

	}

	public String cadastrarAvaliacaoDoAluno(String matriculaDoAluno, String codigoDoTurma, BigDecimal nota) {

		try {
			Turma turma = turmaService.recuperarTurma(codigoDoTurma);
			Aluno aluno = recuperarAluno(matriculaDoAluno);
			if (aluno == null || turma == null || nota == null)
				throw new IllegalArgumentException();

			if (turma.getAlunos().containsKey(matriculaDoAluno)) {
				Avaliacao avaliacao = avalicaoService.criarAvalicao(aluno, turma, nota);
				avaliacao = cadastrarrAvaliacao(avaliacao);
				return avaliacao.getCodigo();
			} else {
				throw new IllegalArgumentException();
			}

		} catch (Exception e) {
			return null;
		}

	}

	public boolean cadastrarProfessorEmTurma(Professor profess, String codigoDoTurma) {

		try {
			Turma turma = recuperarTurma(codigoDoTurma);
			Professor proff = turma.getProfessor();
			Professor profess2 = profess;
			if (profess2 != null || proff != null)
				throw new IllegalArgumentException();

			@SuppressWarnings("null")
			ArrayList<Turma> turmasEmQueOProfessorEstá = BuscarTurmasDoProfessor(profess2.getMatricula());
			if (turmaService.DisponibilidadeDeTurma(turma, turmasEmQueOProfessorEstá)) {

				atualizarTurma(turma);

				return true;
			} else
				return false;

		} catch (Exception e) {
			return false;
		}

	}

	public ArrayList<Avaliacao> buscarAvaliacoesDoAlunoNaTurma(String matriculaCodigo) {
		return avalicaoService.buscarAvaliacoesDoAlunoNaTurma(matriculaCodigo);

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
  
	public BigDecimal mediaDoAluno(String matricula, String codigoDaTurma) {
		Boletim media = criarBotetim(matricula, codigoDaTurma);

		return media.getMedia();

	}

	public Historico CriarHistorico(String matricula) {
		Historico historico = historicoService.criarHistotico();
		ArrayList<Turma> turmasDoAluno = BuscarTurmasDoAluno(matricula);
		ArrayList<Boletim> boletim = new ArrayList<>();
		for (Turma turma : turmasDoAluno) {
			boletim.add(criarBotetim(matricula, turma.getCodigo()));

		}
		historico.setMatriculaDoAluno(matricula);
		historico.setBoletim(boletim);
		return historico;

	}

	public StatusAcademico SituacaoAcademica(String matricula, String codigoDaTurma) {
		BigDecimal media = mediaDoAluno(matricula, codigoDaTurma);
		BigDecimal number4 = new BigDecimal("4");
		BigDecimal number6 = new BigDecimal("6");
		
		if (media.compareTo(number4) == -1 )
			return  StatusAcademico.REPROVADO;
		else 
			if((media.compareTo(number4) == 0) || (media.compareTo(number4) == 1) && (media.compareTo(number6) == -1)) 
				return StatusAcademico.PROVA_FINAL;
			else 
				return StatusAcademico.APROVADO;
		
		
		
	}
}