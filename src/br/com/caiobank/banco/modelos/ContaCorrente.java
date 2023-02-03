package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta corrente
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class ContaCorrente extends Conta implements Tributavel {

	private double faturaCartaoCredito;
	private boolean tributoDestaContaFoiPago;
	
	/**
	 * Construtor para inicializar o objeto ContaCorrente a partir dos parametros
	 * 
	 * @param agencia
	 * @param conta
	 * @param titular
	 */
	
	public ContaCorrente(int agencia, int conta, Cliente titular) {
		super(agencia, conta, titular);
		this.tipoDeConta = "Corrente";
	}

	/**
	 * Valida se possui limite para realizar o pagamento
	 * 
	 * @param valor
	 * @return boolean
	 */
	
	public boolean validaPagamentoCredito(double valor) {
		double limite = 1000;
		
		if(this.faturaCartaoCredito + valor <= limite) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Realiza o pagamento no credito e acrescenta o valor na fatura
	 * 
	 * @param valor
	 */
	
	public void pagarNoCredito(double valor) {
		if(validaPagamentoCredito(valor)) {
			this.faturaCartaoCredito += valor;
			System.out.println("Transação aprovada!");
			return;
		}
		System.out.println("Transação inválida!");
	}
	
	/**
	 * Verifica se esta certo o valor a ser pago e paga a fatura
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
	public void pagaFatura(double valor) throws SaldoInsuficienteException {
		if(valor > this.faturaCartaoCredito) {
			System.out.println("Pagamento maior que o valor da fatura!");
			return;
		}
		saca(valor);
		this.faturaCartaoCredito -= valor;
	}
	
	@Override
	public double tributosDaConta() {
		return 150.0;
	}
	
	@Override
	public void pagaTotalDeTributos() throws SaldoInsuficienteException, PagamentoInvalidoException {
		if(this.getTitular().getGerenciadorTributos().todosOsTributosForamPagos() == false) {
			this.saca(this.getTitular().getGerenciadorTributos().getTotalDeTributos());
			this.getTitular().getGerenciadorTributos().recebeValorDosTributos(this.getTitular().getGerenciadorTributos().getTotalDeTributos());
			return;
		}
		System.out.println("Todos seus Tributos já foram pagos");
	}
	
	@Override
	public void pagaTributo(Tributavel conta) throws SaldoInsuficienteException, PagamentoInvalidoException {
		if(conta.isTributoDestaContaFoiPago() == false) {
			this.saca(this.getTitular().getGerenciadorTributos().getTributo(conta));
			this.getTitular().getGerenciadorTributos().recebeValorDeUmTributo(this.getTitular().getGerenciadorTributos().getTributo(conta), conta);
			conta.setTributoDestaContaFoiPago(true);
			return;
		}
		System.out.println("Tributo já foi pago");
	}
	
	//Getter
	
	public double getFaturaCartaoCredito() {
		return faturaCartaoCredito;
	}

	@Override
	public boolean isTributoDestaContaFoiPago() {
		return this.tributoDestaContaFoiPago;
	}

	@Override
	public void setTributoDestaContaFoiPago(boolean tributoDestaContaFoiPago) {
		this.tributoDestaContaFoiPago = tributoDestaContaFoiPago;
	}

	

}
