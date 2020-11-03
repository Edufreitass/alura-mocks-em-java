package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;

public class GeradorDePagamento {

	private final RepositorioDeLeiloes leiloes;
	private final Avaliador avaliador;
	private final RepositorioDePagamentos pagamentos;

	public GeradorDePagamento(RepositorioDeLeiloes leiloes, RepositorioDePagamentos pagamentos, Avaliador avaliador) {
		this.leiloes = leiloes;
		this.pagamentos = pagamentos;
		this.avaliador = avaliador;
	}

	public void gera() {
		// Lista dos os leiloes encerrados
		List<Leilao> leiloesEncerrados = this.leiloes.encerrados();

		// Para cada leilao..
		for (Leilao leilao : leiloesEncerrados) {
			// avaliamos
			this.avaliador.avalia(leilao);

			// descobrimos o seu maior lance..
			Pagamento novoPagamento = new Pagamento(avaliador.getMaiorLance(), Calendar.getInstance());
			// e geramos um novo pagamento
			this.pagamentos.salva(novoPagamento);
		}
	}

}
