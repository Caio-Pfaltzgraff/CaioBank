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
	protected double saldo, taxaDeSaque, taxaDeTransferencia;
	protected String tipoDeConta;
	private Cliente titular;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir dos parametros
	 * Poderia ja guardar toda conta instaciada pelo construtor
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public Conta(int agencia, int conta, Cliente titular) {
		this.agencia = agencia;
		this.numeroConta = conta;
		this.titular = titular;
		this.titular.getContas().add(this);
		GuardaContasCaiobank.adicionar(this);
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
	 * Valor precisa ser maior do que o saldo e aplica a taxa de cada tipo de conta
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
	public void saca(double valor) throws SaldoInsuficienteException {
		double valorComTaxa = valor + this.taxaDeSaque;
		
		if(this.saldo < valorComTaxa) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " + "Valor necessário para realizar esta ação: " + valorComTaxa);
		}
		
		this.saldo -= valorComTaxa;
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
	
	/**
	 * Retorna as informacoess do objeto, ex: agencia, numero da conta e nome do titular
	 * @return dadosDaConta
	 */
	
	@Override
	public String toString() {
		
		return "Agencia: " + this.getAgencia() + ", Numero da Conta: " + this.getNumeroConta() + ", Titular: " +
			this.titular.getNome() + ", Tipo de Conta: " + this.getTipoDeConta();
	}
	
	/**
	 * Verifica se o numero e agencia da conta e igual ao de outra conta
	 */
	@Override
	public boolean equals(Object obj) {
		Conta outra = (Conta) obj;
		
		if(this.agencia == outra.getAgencia() && this.numeroConta == outra.getNumeroConta()) {
			return true;
		}
		return false;
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
	public String getTipoDeConta() {
		return this.tipoDeConta;
	}
	
}
