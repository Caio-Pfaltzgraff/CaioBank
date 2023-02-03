package br.com.caiobank.banco.modelos;

/**
 * Exception criada que valida os pagamentos
 * 
 * @author Caio Pfaltgraff
 *
 */

public class PagamentoInvalidoException extends Exception {

	/**
	 * Construtor que retorna a mensagem da Exception
	 * 
	 * @param msg
	 */
	
	public PagamentoInvalidoException(String msg) {
		super(msg);
	}
	
}
