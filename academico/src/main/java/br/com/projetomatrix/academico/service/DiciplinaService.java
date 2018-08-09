package br.com.projetomatrix.academico.service;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.modelo.Diciplina;

public class DiciplinaService {
	private int sequencial = 0;

	private Map<String, Diciplina> hashDiciplina = new HashMap<>();

	public Diciplina cadastrarTurma(Diciplina diciplina) {

		if (diciplina == null || hashDiciplina.containsKey(diciplina.getCodigo()))
			throw new IllegalArgumentException();
		if (diciplina.getCodigo() == null)
			diciplina.setCodigo(gerarCodigo());
		hashDiciplina.put(diciplina.getCodigo(), diciplina);
		return diciplina;
	}

	public Diciplina recuperarTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashDiciplina.get(codigo);
	}

	public void removerTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashDiciplina.remove(codigo);
	}

	public void atualizarTurma(Diciplina diciplina) {
		if (diciplina == null || diciplina.getCodigo() == null || diciplina.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerTurma(diciplina.getCodigo());
		cadastrarTurma(diciplina);
	}

	public String gerarCodigo() {
		sequencial++;

		return Integer.toString(sequencial);
	}

}
