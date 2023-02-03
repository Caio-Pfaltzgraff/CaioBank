package br.com.caiobank.banco.modelos;

/**
 * Exception criada que verifica se possui saldo para realizar alguma atividade
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class SaldoInsuficienteException extends Exception {
	
	/**
	 * Construtor que retorna a mensagem da Exception
	 * 
	 * @param msg
	 */

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
}
