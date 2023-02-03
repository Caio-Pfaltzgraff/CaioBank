package br.com.caiobank.banco.modelos;

/**
 * Classe que calcula e recebe os tributos de uma classe que implementa a
 * interface Tributavel
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class GerenciadorDeTributos {

	private double totalDeTributos = 0, tributosPagos = 0;
	private boolean tributosForamPagos;
	private Cliente cliente;
	
	public GerenciadorDeTributos(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo que pega todas as contas de um cliente e verifica se alguma delas
	 * implementa a interface Tributavel e armazena o valor total do tributo das
	 * contas
	 * 
	 * @param cliente
	 */

	private void calculaTributos() {
		for (Conta conta : this.cliente.getContas()) {
			if (conta instanceof Tributavel) {
				this.totalDeTributos += ((Tributavel) conta).tributosDaConta();
			}
		}
	}

	/**
	 * Metodo que retorna o total de tributos de todas as contas de um cliente
	 * 
	 * @param cliente
	 * @return totalDeTributos
	 */

	public double getTotalDeTributos() {
		if (this.tributosForamPagos) {
			return 0;
		}
		this.zeraTotalDeTributos();
		this.calculaTributos();
		this.totalDeTributos -= this.tributosPagos;
		return totalDeTributos;
	}

	/**
	 * Retorna o valor de 1 tributo em especifico
	 * 
	 * @param conta
	 * @return tributosDaConta()
	 */

	public double getTributo(Tributavel conta) {
		return conta.tributosDaConta();
	}

	/**
	 * Verifica se o pagamento e valido e diz que todos os tributos foram pagos
	 * 
	 * @param valor
	 * @throws PagamentoInvalidoException
	 */

	public void recebeValorDosTributos(double valor) throws PagamentoInvalidoException {
		if (valor < totalDeTributos || valor > totalDeTributos) {
			throw new PagamentoInvalidoException(
					"Valor do pagamento é maior ou menor que valor dos tributos, Tente novamente");
		}
		this.totalDeTributos -= valor;
		this.tributosForamPagos = true;
	}

	/**
	 * Verifica se o pagamento de determinado tributo e valido
	 * 
	 * @param valor
	 * @param conta
	 * @throws PagamentoInvalidoException
	 */

	public void recebeValorDeUmTributo(double valor, Tributavel conta) throws PagamentoInvalidoException {
		if (valor < conta.tributosDaConta() || valor > conta.tributosDaConta()) {
			throw new PagamentoInvalidoException(
					"Valor do pagamento é maior ou menor que valor dos tributos, Tente novamente");
		}
		totalDeTributos -= valor;
		armazenaValorDosTributosPagos(valor);
		if (totalDeTributos == 0) {
			tributosForamPagos = true;
		}
	}

	/**
	 * Zera o total de tributos
	 */
	private void zeraTotalDeTributos() {
		totalDeTributos = 0;
	}
	
	/**
	 * Armazena o valor dos tributos para quando for calcular o valor descontar o que ja foi pago
	 * 
	 * @param valor
	 */

	private void armazenaValorDosTributosPagos(double valor) {
		tributosPagos += valor;
	}
	
	/**
	 * Retorna se todos os tributos foram pagos
	 * 
	 * @return
	 */
	
	public boolean todosOsTributosForamPagos() {
		return this.tributosForamPagos;
	}

}
