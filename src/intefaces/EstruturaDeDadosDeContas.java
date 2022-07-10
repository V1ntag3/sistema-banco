package intefaces;

import classesPrincipais.Conta;
import excexoes.ContaInexistente;

public interface EstruturaDeDadosDeContas {

	public Conta pesquisar(int n) throws ContaInexistente;

	public void incluir(Conta c);
}
