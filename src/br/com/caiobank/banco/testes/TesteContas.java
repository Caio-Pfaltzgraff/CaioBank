package br.com.caiobank.banco.testes;

import br.com.caiobank.banco.modelos.Cliente;
import br.com.caiobank.banco.modelos.ContaCorrente;
import br.com.caiobank.banco.modelos.ContaDigital;
import br.com.caiobank.banco.modelos.ContaPoupanca;
import br.com.caiobank.banco.modelos.ContaSalario;
import br.com.caiobank.banco.modelos.Endereco;
import br.com.caiobank.banco.modelos.PagamentoInvalidoException;
import br.com.caiobank.banco.modelos.SaldoInsuficienteException;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException, PagamentoInvalidoException {
		Endereco enderecoCaio = new Endereco(26525037, "Nilópolis", 35, "Tv. Luiz Gonçalves Júnior");
		Cliente caio = new Cliente("154-904-817.04", enderecoCaio, "Caio Roberto de Oliveira Pfaltzgraff", 980851773);
		
		ContaPoupanca cp = new ContaPoupanca(123, 4058, caio);
		ContaCorrente cc = new ContaCorrente(123, 1514, caio);
		ContaSalario cs = new ContaSalario(123, 9672, 5000, caio);
		ContaDigital cd = new ContaDigital(123, 8617, caio);
		
		System.out.println(caio.getGerenciadorTributos().getTotalDeTributos());
		
		cd.deposita(2000.0);
		cc.deposita(200.0);
		
		cd.pagaTributo(cc);
		cc.pagaTributo(cc);
		
		System.out.println(caio.getGerenciadorTributos().getTotalDeTributos());
		System.out.println(cc.getSaldo());

	}

}
