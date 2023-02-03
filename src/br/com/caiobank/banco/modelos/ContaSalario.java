package br.com.caiobank.banco.modelos;

/**
 * Classe que representa uma conta salario
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class ContaSalario extends Conta implements Tributavel {
	
	private double salario, reservaDeEmergencia, contasParaPagar;
	private boolean salarioEstaDividido, tributoDestaContaFoiPago;
	
	/**
	 * Construtor para inicializar um objeto ContaSalario a partir dos parametros recebidos, e recebe o valor de
	 * seus atributos
	 * 
	 * @param agencia
	 * @param conta
	 * @param salario
	 * @param titular
	 */

	public ContaSalario(int agencia, int conta, double salario, Cliente titular) {
		super(agencia, conta, titular);
		this.salario = salario;
		this.tipoDeConta = "Salário";
	}
	
	/**
	 * Representa o pagamento de salario, adiciona o salario ao saldo da conta
	 */
	
	public void recebeSalario() {
		this.saldo += getSalario();
		this.salarioEstaDividido = false;
	}
	
	/**
	 * Altera o valor do salario
	 * 
	 * @param valor
	 */
	
	public void novoSalario(double valor) {
		this.salario = valor;
	}
	
	/**
	 * Verifica se o salario esta dividido conta que divide o salario em 50% para pagar as contas e adiciona 20% 
	 * a reserva de emergencia
	 * 
	 * @throws SaldoInsuficienteException
	 */
	
	public void divideSeuSalario() throws SaldoInsuficienteException {
		if(this.salarioEstaDividido == false) {
			double recomendacaoContas = getSalario() * 0.5;
			double recomendacaoReservaDeEmergencia = getSalario() * 0.2;
			double total = recomendacaoContas + recomendacaoReservaDeEmergencia;
			
			this.saca(total);
			this.contasParaPagar += recomendacaoContas;
			this.reservaDeEmergencia += recomendacaoReservaDeEmergencia;
			this.salarioEstaDividido = true;
		}
		System.out.println("Salário já está dividido.");
	}
	
	/**
	 * Representa o pagamento mensal de contas e se o salario estiver dividido retira do valor que foi destinado
	 * a pagar as contas
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
	public void pagaContas(double valor) throws SaldoInsuficienteException {
		if(valor <= this.contasParaPagar) {
			this.contasParaPagar -= valor;
		}
		if(valor > contasParaPagar) {
			valor -= this.contasParaPagar;
			this.saca(valor);
			this.contasParaPagar = 0;
		}
	}
	
	@Override
	public double tributosDaConta() {
		return this.getSalario() * 0.2;
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
	
	// Getters e Setter
	
	public double getSalario() {
		return this.salario;
	}
	
	public double getReservaDeEmergencia() {
		return this.reservaDeEmergencia;
	}
	
	public double getContasParaPagar() {
		return this.contasParaPagar;
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
