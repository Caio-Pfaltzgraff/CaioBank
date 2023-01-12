package br.com.caiobank.banco.modelos;

/**
 * Exception criada que verifica se possui saldo para realizar alguma atividade
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class SaldoInsuficienteException extends Exception {
	
	/**
	 * Construtor que Lança a mensagem da exception
	 * 
	 * @param msg
	 */

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
}
