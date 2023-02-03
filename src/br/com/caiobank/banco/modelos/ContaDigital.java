package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta digital
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class ContaDigital extends ContaCorrente {

	/**
	 * Construtor que inicializa um objeto ContaDigital a partir dos parametros
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public ContaDigital(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
		this.tipoDeConta = "Digital";
	}
	
	@Override
	public double tributosDaConta() {
		return 0;
	}

}
