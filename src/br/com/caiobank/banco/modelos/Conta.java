package br.com.caiobank.banco.modelos;

public abstract class Conta {

	private int agencia;
	private int numeroConta;
	protected double saldo;
	private Cliente titular;
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	public void saca(double valor) throws SaldoInsuficienteException {
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " + "Valor que deseja sacar: " + valor);
		}
		this.saldo -= valor;
		//criar a validação de taxa
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
		System.out.println("Transferência feita com Sucesso!");
	}
	
	public Conta(int agencia, int conta, Cliente titular) {
		this.agencia = agencia;
		this.numeroConta = conta;
		this.titular = titular;
	}
	
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
