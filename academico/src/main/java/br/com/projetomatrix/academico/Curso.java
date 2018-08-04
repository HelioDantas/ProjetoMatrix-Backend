package br.com.projetomatrix.academico;

import java.util.List;

public class Curso {
	private String descricao;
	private String codigo;
	private String ementa;
	private Integer cagarHoraria;
	private String bibliografia;
	private Coordenador coordenador;
	private List<Diciplina> disciplinas;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Integer getCagarHoraria() {
		return cagarHoraria;
	}

	public void setCagarHoraria(Integer cagarHoraria) {
		this.cagarHoraria = cagarHoraria;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<Diciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Diciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
