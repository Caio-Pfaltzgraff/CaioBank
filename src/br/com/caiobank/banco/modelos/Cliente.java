package br.com.caiobank.banco.modelos;

public class Cliente {

	private String nome;
	private int telefone;
	private String cpf;
	private Endereco endereco;

	public Cliente(String cpf, Endereco endereco, String nome, int telefone) {
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
