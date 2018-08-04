package br.com.projetomatrix.academico;



public class Pessoa {

	private String name;
	private Endereco endereco;
	private String telefone;
	private String cpf;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
