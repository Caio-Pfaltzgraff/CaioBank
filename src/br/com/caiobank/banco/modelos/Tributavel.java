package br.com.caiobank.banco.modelos;

/**
 * Interface que gera um tributo e realiza pagamentos deles
 * 
 * @author Caio Pfaltzgraff
 *
 */

public interface Tributavel {

	/**
	 * Gera o tributo das conta em que for implementada
	 * 
	 * @return
	 */
	
	double tributosDaConta();
	
	/**
	 * Efetua o pagamento de todos os tributos
	 * 
	 * @throws SaldoInsuficienteException
	 * @throws PagamentoInvalidoException
	 */
	
	void pagaTotalDeTributos() throws SaldoInsuficienteException, PagamentoInvalidoException;
	
	/**
	 * Efetua o pagamento de determinado tributo
	 * 
	 * @param conta
	 * @throws SaldoInsuficienteException
	 * @throws PagamentoInvalidoException
	 */
	
	void pagaTributo(Tributavel conta) throws SaldoInsuficienteException, PagamentoInvalidoException;
	
	/**
	 * Retorna se o tributo foi pago ou nao
	 * 
	 * @return
	 */
	
	boolean isTributoDestaContaFoiPago();
	
	/**
	 * Altera se o tributo foi pago ou nao
	 * 
	 * @param tributoDestaContaFoiPago
	 */
	
	void setTributoDestaContaFoiPago(boolean tributoDestaContaFoiPago);
	
}
