package br.com.projetomatrix.academico.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.modelo.Coordenador;

public class CoordenadorService {
	private int sequencial = 0;

	private Map<String, Coordenador> hashCoordenador = new HashMap<>();

	public Coordenador cadastrarCoordenador(Coordenador coordenador) {

		if (coordenador == null || hashCoordenador.containsKey(coordenador.getMatricula()))
			throw new IllegalArgumentException();
		if(coordenador.getMatricula() == null)
			coordenador.setMatricula(gerarMatricular(coordenador));
		return coordenador;
	}

	public Coordenador recuperarCoordenador(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		return hashCoordenador.get(matricula);
	}

	public void removerCoordenador(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		hashCoordenador.remove(matricula);
	}

	public void atualizarCoordenador(Coordenador coordenador) {
		if (coordenador == null || coordenador.getMatricula() == null || coordenador.getMatricula().length() == 0)
			throw new IllegalArgumentException();

		removerCoordenador(coordenador.getMatricula());
		cadastrarCoordenador(coordenador);

	}

	private String gerarMatricular(Coordenador professor) {
		// TODO Auto-generated method stub
		int ano = LocalDateTime.now().getYear();
		String anoconvertido = Integer.toString(ano);
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		sequencial++;
		String StringSequencial = Integer.toString(sequencial);
		String matricula = anoconvertido + "." + semestre + "." + StringSequencial;

		return matricula;
	}

}
