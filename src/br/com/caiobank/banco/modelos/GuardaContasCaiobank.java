package br.com.caiobank.banco.modelos;

import java.util.ArrayList;

/**
 * Classe que armazena todas as contas criadas no caiobank
 * 
 * @author Caio Pfaltzgraff
 *
 */

public class GuardaContasCaiobank {

	private static ArrayList<Conta> contas = new ArrayList<>(100);
	private static int indice = 1;
	
	public static void adicionar(Conta novaConta) {
		if(contas.contains(novaConta)) {
			return;
		}
		contas.add(novaConta);
		contas.sort( (c1, c2) -> c1.getTitular().getNome().compareTo( c2.getTitular().getNome() ) );
	}
	
	public static void mostraTodasContas() {
		System.out.println("Lista de contas Caiobank(Total: " + contas.size() + "):");
		contas.forEach( (conta) -> System.out.println(indice++ + ")" + conta) );
	}
	
	public static String pesquisaConta(int agencia, int numero) {
		for(Conta lista : contas) {
			if(lista.getAgencia() == agencia && lista.getNumeroConta() == numero) {
				return lista.toString();
			}
		}
		return "Não temos essa conta no banco!";
	}
	
}

/*
  criar a classe que armazena as contas de um cliente em especifico */
