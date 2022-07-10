package classesPrincipais;

import estruturaDados.VetorDeContas;
import excexoes.ContaInexistente;
import excexoes.NaoEhPoupanca;
import excexoes.SaldoInsuficiente;
import intefaces.EstruturaDeDadosDeContas;

public class Banco {

	private EstruturaDeDadosDeContas contas = new VetorDeContas();

	public void incluir(Conta c) {
		contas.incluir(c);
	}

	private Conta pesquisar(int n) throws ContaInexistente {
		return contas.pesquisar(n);
	}

	public void saque(int n, double v) throws ContaInexistente, SaldoInsuficiente {
		Conta c = pesquisar(n);
		if (c != null) {
			c.debito(v);
		}
	}

	public void deposito(int n, double v) throws ContaInexistente {
		Conta c = pesquisar(n);
		if (c != null) {
			c.credito(v);
		}
	}

	public void rendeJuros(int n, double t) throws ContaInexistente, NaoEhPoupanca {
		Conta c = pesquisar(n);
		if (c != null) {
			if (c instanceof Poupanca) {
				((Poupanca) c).renderJuros(t);

			}
		}
	}

	public double saldo(int n) throws ContaInexistente {
		Conta c = pesquisar(n);
		if (c != null) {
			return c.getSaldo();
		}
		return -999999;
	}

	public String extrato(int n) throws ContaInexistente {
		Conta c = pesquisar(n);
		if (c != null) {
			return c.getExtrato();
		}
		return "";
	}
}
