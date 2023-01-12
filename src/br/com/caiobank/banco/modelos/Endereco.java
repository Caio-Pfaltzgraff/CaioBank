package br.com.caiobank.banco.modelos;

/**
 * Classe que representa um endereco
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class Endereco {

	private String rua;
	private int numeroRua;
	private String cidade;
	private int cep;
	
	/**
	 * Construtor para inicializar o objeto Endereco a partir dos parametros
	 * 
	 * @param cep
	 * @param cidade
	 * @param numeroRua
	 * @param rua
	 */
	
	public Endereco(int cep, String cidade, int numeroRua, String rua) {
		this.cep = cep;
		this.cidade = cidade;
		this.numeroRua = numeroRua;
		this.rua = rua;
	}
	
	/**
	 * Mostra o endereco
	 * 
	 * @return Rua + Número + Cidade
	 */

	public String mostraEndereco() {
		return this.getRua() + " " + this.getNumeroRua() + ", " + this.getCidade();
	}
	
	//Getters e Setters

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(int numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

}
