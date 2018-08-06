package br.com.projetomatrix.academico.service;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.modelo.Curso;

public class CursoService {
	private int sequencial = 0;

	private Map<String, Curso> hashCursos = new HashMap<>();

	public Curso cadastrarCurso(Curso curso) {

		if (curso == null || hashCursos.containsKey(curso.getCodigo()))
			throw new IllegalArgumentException();

		curso.setCodigo(gerarCodigo());
		return curso;
	}

	public Curso recuperarCurso(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashCursos.get(codigo);
	}

	public void removerCurso(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashCursos.remove(codigo);
	}

	public void atualizarCurso(Curso curso) {
		if (curso == null || curso.getCodigo() == null || curso.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		recuperarCurso(curso.getCodigo());
		cadastrarCurso(curso);

	}

	public String gerarCodigo() {
		sequencial++;

		return Integer.toString(sequencial);
	}

}
