package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta poupanca
 * 
 * @author Caio Pfaltzgarff
 *
 */

public class ContaPoupanca extends Conta {
	
	private int totalDeTransferencias = 2;
	
	/**
	 * Construtor para inicializar o objeto ContaCorrente a partir dos parametros
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public ContaPoupanca(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
	}
	
	/**
	 * Metodo saca sobrescrito que aplica taxa ao saque
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
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
	
	/**
	 * Metodo transfere sobrescrito que aplica taxa ao passar do total de transferencias
	 * 
	 * @param valor
	 * @param destino
	 * @throws SaldoInsuficienteException
	 */

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
	
	/**
	 * Verifica se resta transferencias gratuitas
	 * 
	 * @return boolean
	 */
	
	private boolean verificaTotalTransferencia() {
		
		if(this.totalDeTransferencias >= 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Se nao possuir saldo, lança a exception
	 * 
	 * @param valor
	 * @return
	 * @throws SaldoInsuficienteException
	 */
	
	private boolean verificaSaldo(double valor) throws SaldoInsuficienteException {
		
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo atual: " + this.saldo + ", " 
		+ "Valor que precisa para transferir: " + valor);
		}
		return true;
	}
	
	//Getter
	
	public int getTotalDeTransferencias() {
		return totalDeTransferencias;
	}
	
}
