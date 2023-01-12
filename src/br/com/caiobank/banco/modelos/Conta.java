package br.com.caiobank.banco.modelos;

/**
 * Classe que representa a moldura de uma conta
 * 
 * @author Caio Pfaltzgraff
 *
 */

public abstract class Conta {

	private int agencia;
	private int numeroConta;
	protected double saldo;
	private Cliente titular;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir dos parametros
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public Conta(int agencia, int conta, Cliente titular) {
		this.agencia = agencia;
		this.numeroConta = conta;
		this.titular = titular;
	}
	
	/**
	 * Deposita um valor ao saldo
	 * 
	 * @param valor
	 */
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	/**
	 * Valor precisa ser maior do que o saldo.
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " + "Valor que deseja sacar: " + valor);
		}
		this.saldo -= valor;
	}
	
	/**
	 * Verifica e retira o saldo da conta e deposita na conta destino
	 * 
	 * @param valor
	 * @param destino
	 * @throws SaldoInsuficienteException
	 */
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
		System.out.println("Transferência feita com Sucesso!");
	}
	
	//Getters e Setters
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public Cliente getTitular() {
		return titular;
	}
	
}
