package br.com.caiobank.banco.modelos;

public class ContaPoupanca extends Conta {
	
	private int totalDeTransferencias = 2;
	
	public ContaPoupanca(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		
		double taxa = 0.20, valorDeSaque = valor + taxa;
		
		if(this.saldo < valorDeSaque) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " + "Valor que deseja sacar: " 
			+ valor + " + Taxa de saque: " + taxa);
		}
		
		super.saldo -= valorDeSaque;
		System.out.println("Saque de " + valor + "R$ efetuado!");
		
	}

	@Override
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		
		double valorComTaxa = valor + 1.0;
		
		if(verificaTotalTransferencia() && verificaSaldo(valor)) {
			this.totalDeTransferencias -= 1;
			
			this.saldo -= valor;
			destino.deposita(valor);
			
		} else if(verificaTotalTransferencia() == false && verificaSaldo(valorComTaxa)) {
			
			this.saldo -= valorComTaxa;
			destino.deposita(valor);
		}
		System.out.println("Transferência feita com sucesso!");
		
	}
	
	private boolean verificaTotalTransferencia() {
		
		if(this.totalDeTransferencias >= 1) {
			return true;
		}
		return false;
	}
	
	private boolean verificaSaldo(double valor) throws SaldoInsuficienteException {
		
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " 
		+ "Valor que precisa para transferir: " + valor);
		}
		return true;
	}
	
	public int getTotalDeTransferencias() {
		return totalDeTransferencias;
	}
	
}
