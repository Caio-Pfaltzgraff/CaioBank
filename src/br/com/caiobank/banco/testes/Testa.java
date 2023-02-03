package br.com.caiobank.banco.testes;

import br.com.caiobank.banco.modelos.Cliente;
import br.com.caiobank.banco.modelos.ContaCorrente;
import br.com.caiobank.banco.modelos.ContaPoupanca;
import br.com.caiobank.banco.modelos.Endereco;
import br.com.caiobank.banco.modelos.GuardaContasCaiobank;
import br.com.caiobank.banco.modelos.PagamentoInvalidoException;
import br.com.caiobank.banco.modelos.SaldoInsuficienteException;

public class Testa {

	public static void main(String[] args) throws SaldoInsuficienteException, PagamentoInvalidoException {
		
		Endereco enderecoCaio = new Endereco(26525037, "Nilópolis", 35, "Tv. Luiz Gonçalves Júnior");
		Endereco enderecoRuan = new Endereco(26525046, "Nilópolis", 96, "Rua Helena");
		
		Cliente caio = new Cliente("154-904-817.04", enderecoCaio, "Caio Roberto de Oliveira Pfaltzgraff", 980851773);
		Cliente ruan = new Cliente("454-518-908.54", enderecoRuan, "Ruan Roberto de Oliveira Pfaltzgraff", 996527428);
		
		ContaCorrente contaCorrenteCaio = new ContaCorrente(187, 1502, caio);
		ContaPoupanca contaPoupancaCaio = new ContaPoupanca(986, 1012, caio);
		
		ContaCorrente contaCorrenteRuan = new ContaCorrente(176, 0310, ruan);
		ContaPoupanca contaPoupancaRuan = new ContaPoupanca(920, 1312, ruan);
		
		//Implementation
		contaCorrenteCaio.deposita(5000.0);
		contaCorrenteRuan.deposita(4000.0);
		
		contaCorrenteCaio.transfere(2500, contaPoupancaCaio);
		contaCorrenteRuan.transfere(2000, contaPoupancaRuan);
		
//		contaPoupancaCaio.transfere(500.0, contaPoupancaRuan);
//		contaPoupancaCaio.transfere(500.0, contaPoupancaRuan);
//		contaPoupancaCaio.transfere(500.0, contaPoupancaRuan);
		
		GuardaContasCaiobank.mostraTodasContas();
		System.out.println();
		
		caio.mostraContas();
		System.out.println();
		
		System.out.println(caio.getGerenciadorTributos().getTotalDeTributos());
		contaCorrenteCaio.pagaTotalDeTributos();
		System.out.println(caio.getGerenciadorTributos().getTotalDeTributos());
		
		System.out.println("Tributos Ruan: " + ruan.getGerenciadorTributos().getTotalDeTributos());
		
		contaPoupancaCaio.transfere(2501.0, contaPoupancaRuan);
		
		System.out.println(contaPoupancaCaio.getSaldo());
		System.out.println(contaPoupancaRuan.getSaldo());
		
	}
}
