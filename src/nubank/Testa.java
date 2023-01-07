package nubank;

public class Testa {

	public static void main(String[] args) throws SaldoInsuficienteException {
		
		//addresses
		Endereco enderecoCaio = new Endereco(26525037, "Nilópolis", 35, "Tv. Luiz Gonçalves Júnior");
		Endereco enderecoRuan = new Endereco(26525046, "Nilópolis", 96, "Rua Helena");
		
		//customers
		Cliente caio = new Cliente("158-964-317.83", enderecoCaio, "Caio Roberto de Oliveira Pfaltzgraff", 980891793);
		Cliente ruan = new Cliente("454-518-908.54", enderecoRuan, "Ruan Roberto de Oliveira Pfaltzgraff", 996527428);
		
		//bills
		ContaCorrente contaCorrenteCaio = new ContaCorrente(187, 1502, caio);
		ContaPoupanca contaPoupancaCaio = new ContaPoupanca(986, 1012, caio);
		
		ContaCorrente contaCorrenteRuan = new ContaCorrente(176, 0310, ruan);
		ContaPoupanca contaPoupancaRuan = new ContaPoupanca(920, 1312, ruan);
		
		//Implementation CC: right!  CP: 
		contaCorrenteCaio.deposita(5000.0);
		contaCorrenteRuan.deposita(4000.0);
		
		contaCorrenteCaio.transfere(2500, contaPoupancaCaio);
		contaCorrenteRuan.transfere(2000, contaPoupancaRuan);
		
		contaPoupancaCaio.transfere(2501.0, contaPoupancaRuan);
		
		System.out.println(contaPoupancaCaio.getSaldo());
		System.out.println(contaPoupancaRuan.getSaldo());
		
	}
}
