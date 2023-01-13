package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta poupanca
 * 
 * @author Caio Pfaltzgarff
 *
 */

public class ContaPoupanca extends Conta {
	
	private int totalDeTransferenciasGratuitas = 2;
	
	/**
	 * Construtor para inicializar o objeto ContaCorrente a partir dos parametros
	 * informa a classe mae a taxa de saque e de transferencia
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public ContaPoupanca(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
		this.taxaDeSaque = 0.20;
		this.taxaDeTransferencia = 1.0;
	}
	
	/**
	 * Metodo transfere sobrescrito que aplica taxa ao passar do total de transferencias
	 * Utliza o metodo saca para retirar o valor do saldo insentando a taxa de saque
	 * 
	 * @param valor
	 * @param destino
	 * @throws SaldoInsuficienteException
	 */

	@Override
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		
		if(this.totalDeTransferenciasGratuitas > 0) {
			super.saca(valor - this.taxaDeSaque);
			destino.deposita(valor);
			this.totalDeTransferenciasGratuitas--;
		} else {
			super.saca(valor + taxaDeTransferencia - this.taxaDeSaque);
			destino.deposita(valor);
		}
		System.out.println("Transferência feita com sucesso!");
		
	}
	
	//Getter
	
	public int getTotalDeTransferencias() {
		return totalDeTransferenciasGratuitas;
	}
	
}
