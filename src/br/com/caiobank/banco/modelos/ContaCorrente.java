package br.com.caiobank.banco.modelos;

public class ContaCorrente extends Conta {

	private double faturaCartaoCredito;
	
	public ContaCorrente(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
	}
	
	public double getFaturaCartaoCredito() {
		return faturaCartaoCredito;
	}
	
	public boolean validaPagamentoCredito(double valor) {
		double limite = 1000;
		
		if(this.faturaCartaoCredito + valor <= limite) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void pagarNoCredito(double valor) {
		if(validaPagamentoCredito(valor)) {
			this.faturaCartaoCredito += valor;
			System.out.println("Transação aprovada!");
			return;
		}
		System.out.println("Transação inválida!");
	}
	
	public void pagaFatura(double valor) throws SaldoInsuficienteException {
		if(valor > this.faturaCartaoCredito) {
			System.out.println("Pagamento maior que o valor da fatura!");
			return;
		}
		saca(valor);
		this.faturaCartaoCredito -= valor;
	}
}
