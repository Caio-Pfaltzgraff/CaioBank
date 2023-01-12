package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta corrente
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class ContaCorrente extends Conta {

	private double faturaCartaoCredito;
	
	/**
	 * Construtor para inicializar o objeto ContaCorrente a partir dos parametros
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public ContaCorrente(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
	}
	
	/**
	 * Valida se possui limite para realizar o pagamento
	 * 
	 * @param valor
	 * @return boolean
	 */
	
	public boolean validaPagamentoCredito(double valor) {
		double limite = 1000;
		
		if(this.faturaCartaoCredito + valor <= limite) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Realiza o pagamento no credito e acrescenta o valor na fatura
	 * 
	 * @param valor
	 */
	
	public void pagarNoCredito(double valor) {
		if(validaPagamentoCredito(valor)) {
			this.faturaCartaoCredito += valor;
			System.out.println("Transação aprovada!");
			return;
		}
		System.out.println("Transação inválida!");
	}
	
	/**
	 * Verifica se esta certo o valor a ser pago e paga a fatura
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
	public void pagaFatura(double valor) throws SaldoInsuficienteException {
		if(valor > this.faturaCartaoCredito) {
			System.out.println("Pagamento maior que o valor da fatura!");
			return;
		}
		saca(valor);
		this.faturaCartaoCredito -= valor;
	}
	
	//Getter
	
	public double getFaturaCartaoCredito() {
		return faturaCartaoCredito;
	}
}
