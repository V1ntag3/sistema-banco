package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import classesPrincipais.Conta;
import classesPrincipais.ContaComum;
import estruturaDados.NoDaListaDeContas;
import excexoes.ContaInexistente;

public class NoDaListaDeContasTest {

	@Test
	public void testarInclusaoPesquisa() {
		ContaComum c = new ContaComum(1);
		c.credito(99);

		NoDaListaDeContas inicio = new NoDaListaDeContas();
		inicio.incluir(c);
		Conta outra;
		try {
			outra = inicio.pesquisar(1);
			assertEquals(99, outra.getSaldo(), 0.0001);
		} catch (ContaInexistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testarInclusaoPesquisaDeVariasContas() {
		ContaComum c1 = new ContaComum(1);
		c1.credito(10);

		ContaComum c3 = new ContaComum(3);
		c3.credito(30);

		ContaComum c2 = new ContaComum(2);
		c2.credito(20);

		NoDaListaDeContas inicio = new NoDaListaDeContas();
		inicio.incluir(c1);
		inicio.incluir(c3);
		inicio.incluir(c2);

		Conta outra;
		try {
			outra = inicio.pesquisar(3);
			assertEquals(30, outra.getSaldo(), 0.0001);
		} catch (ContaInexistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			outra = inicio.pesquisar(9);
			assertNull(outra);

		} catch (ContaInexistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("1 3 2 ", inicio.listar());
	}

	@Test
	public void testarTamanhoLista() {
		ContaComum c1 = new ContaComum(1);
		c1.credito(10);

		ContaComum c3 = new ContaComum(3);
		c3.credito(30);

		ContaComum c2 = new ContaComum(2);
		c2.credito(20);

		NoDaListaDeContas inicio = new NoDaListaDeContas();
		inicio.incluir(c1);
		inicio.incluir(c3);
		inicio.incluir(c2);

		assertEquals(3, inicio.size());
	}

	@Test
	public void testarTamanhoLista2() {
		ContaComum c1 = new ContaComum(1);
		ContaComum c2 = new ContaComum(2);
		ContaComum c3 = new ContaComum(3);
		ContaComum c4 = new ContaComum(4);
		ContaComum c5 = new ContaComum(5);

		NoDaListaDeContas inicio = new NoDaListaDeContas();
		inicio.incluir(c1);
		inicio.incluir(c2);
		inicio.incluir(c3);
		inicio.incluir(c4);
		inicio.incluir(c5);

		assertEquals(5, inicio.size());
	}

	@Test
	public void testarGet() {
		ContaComum c1 = new ContaComum(1);
		ContaComum c2 = new ContaComum(2);
		ContaComum c3 = new ContaComum(3);
		ContaComum c4 = new ContaComum(4);
		ContaComum c5 = new ContaComum(5);

		NoDaListaDeContas inicio = new NoDaListaDeContas();
		inicio.incluir(c5);
		inicio.incluir(c4);
		inicio.incluir(c3);
		inicio.incluir(c2);
		inicio.incluir(c1);

		assertEquals(5, inicio.get(0).getNum());
		assertEquals(4, inicio.get(1).getNum());
		assertEquals(3, inicio.get(2).getNum());
		assertEquals(2, inicio.get(3).getNum());
		assertEquals(1, inicio.get(4).getNum());

		assertNull(inicio.get(10));
	}
}
