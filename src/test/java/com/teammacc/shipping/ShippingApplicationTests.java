package com.teammacc.shipping;

import com.teammacc.shipping.correiostools.Frete;
import com.teammacc.shipping.correiostools.FreteResult;
import com.teammacc.shipping.correiostools.FreteResultItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShippingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void freteTest() {
		Frete frete = new Frete();
		frete.codServico("41106");
		frete.codFormato(1);
		frete.altura(11d);
		frete.largura(12d);
		frete.comprimento(16d);
		frete.peso("0,450");
		//frete.cepOrigem("13348867");
		//frete.cepDestino("29156034");
		frete.cepOrigem("60415160");
		frete.cepDestino("01021100");
		// Rua Vinte e Cinco de Março - de 552 ao fim - lado par	Centro	São Paulo/SP	01021-100
		FreteResult result = frete.result();
		FreteResultItem servico = result.getServico(41106);

		System.out.println("erro "+servico.getErro());
		System.out.println("mensagem erro "+servico.getMensagemDeErro());
		System.out.println("prazo " + servico.getPrazo());
		System.out.println("valor " + servico.getValor());
		System.out.println("entrega dim " + servico.getEntregaDomiciliar());
		System.out.println("entraga sabado " + servico.getEntregaSabado());
	}

}
