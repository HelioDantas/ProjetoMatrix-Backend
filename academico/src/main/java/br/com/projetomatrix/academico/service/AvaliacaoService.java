package br.com.projetomatrix.academico.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.modelo.Aluno;
import br.com.projetomatrix.academico.modelo.Avaliacao;
import br.com.projetomatrix.academico.modelo.Turma;

public class AvaliacaoService {
	private int sequencial = 0;
	private Map<String, Avaliacao> hashAvalicao = new HashMap<>();

	public Avaliacao criarAvalicao(Aluno aluno, Turma turma, BigDecimal nota) {
		Avaliacao novaAvalicao = new Avaliacao();
		novaAvalicao.setAluno(aluno);
		novaAvalicao.setTurma(turma);
		novaAvalicao.setNota(nota);

		return novaAvalicao;

	}

	public Avaliacao cadastrarAvalicao(Avaliacao avaliacao) {

		if (avaliacao == null || hashAvalicao.containsKey(avaliacao.getCodigo()))
			throw new IllegalArgumentException();

		if (avaliacao.getCodigo() == null)
			avaliacao.setCodigo(gerarCodigo(avaliacao.getAluno().getMatricula(), avaliacao.getTurma().getCodigo()));

		hashAvalicao.put(avaliacao.getCodigo(), avaliacao);
		return avaliacao;
	}

	public Avaliacao recuperarAvalicao(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashAvalicao.get(codigo);
	}

	public void removerAvalicao(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashAvalicao.remove(codigo);
	}

	public void atualizarAvalicao(Avaliacao avaliacao) {
		if (avaliacao == null || avaliacao.getCodigo() == null || avaliacao.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerAvalicao(avaliacao.getCodigo());
		cadastrarAvalicao(avaliacao);
	}

	public String gerarCodigo(String aluno, String turma) {
		ArrayList<Avaliacao> avaliacoesDoAluno = buscarAvaliacoesDoAlunoNaTurma(aluno + turma);
		if (avaliacoesDoAluno.size() == 3)
			throw new IllegalArgumentException();
		return turma + aluno + Integer.toString(sequencial);
	}

	public ArrayList<Avaliacao> buscarAvaliacoesDoAlunoNaTurma(String matriculaCodigo) {
		ArrayList<Avaliacao> todasAsAvaliacoesNaTurma = new ArrayList<>();

		for (String key : hashAvalicao.keySet()) {
			if (key.contains(matriculaCodigo))
				todasAsAvaliacoesNaTurma.add(hashAvalicao.get(key));

		}

		return todasAsAvaliacoesNaTurma;
	}

}
