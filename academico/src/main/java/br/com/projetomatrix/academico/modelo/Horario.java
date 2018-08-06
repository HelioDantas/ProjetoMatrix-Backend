package br.com.projetomatrix.academico.modelo;

import br.com.projetomatrix.academico.enumm.DiaDaSemana;

public class Horario {
	private DiaDaSemana diaDaSemana;
	private String horarioDeInicio;
	private String horarioDeFim;

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getHorarioDeInicio() {
		return horarioDeInicio;
	}

	public void setHorarioDeInicio(String horarioDeInicio) {
		this.horarioDeInicio = horarioDeInicio;
	}

	public String getHorarioDeFim() {
		return horarioDeFim;
	}

	public void setHorarioDeFim(String horarioDeFim) {
		this.horarioDeFim = horarioDeFim;
	}

}
