package br.com.caiobank.banco.modelos;

import java.util.ArrayList;

/**
 * Classe que representa um cliente
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class Cliente {

	private String nome;
	private long telefone;
	private short indice = 1;
	private String cpf;
	private Endereco endereco;
	private ArrayList<Conta> contas = new ArrayList<>();
	private GerenciadorDeTributos gerenciadorTributos = new GerenciadorDeTributos(this);
	
	/**
	 * Construtor para inicializar o objeto Cliente a partir dos parametros
	 * 
	 * @param cpf
	 * @param endereco
	 * @param nome
	 * @param telefone
	 */

	public Cliente(String cpf, Endereco endereco, String nome, int telefone) {
		this.cpf = cpf;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	/**
	 * Mostra todas as contas que o cliente possui
	 */
	
	public void mostraContas() {
		if(this.contas.size() >= 1) {
			System.out.println("Contas do " + this.nome.split(" ")[0] + ":");
			contas.forEach((conta) -> System.out.println(indice++ + ") " + conta));
			this.indice = 1; return;
		}
		System.out.println("Você não possui conta no nosso banco");
	}
	
	
	
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public long getTelefone() {
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
	public ArrayList<Conta> getContas() {
		return this.contas;
	}
	public GerenciadorDeTributos getGerenciadorTributos() {
		return gerenciadorTributos;
	}
	
}
