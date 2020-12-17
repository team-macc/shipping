package com.teammacc.shipping.service;

import com.teammacc.shipping.correiostools.Frete;
import com.teammacc.shipping.correiostools.FreteResult;
import com.teammacc.shipping.correiostools.FreteResultItem;
import com.teammacc.shipping.data.vo.ShippingVO;
import com.teammacc.shipping.exceptions.CepInvalidoException;
import com.teammacc.shipping.exceptions.ErroDesconhecidoException;
import com.teammacc.shipping.exceptions.NumeroInvalidoException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ShippingService {

    private final Logger logger = Logger.getLogger(ShippingService.class.getName());

    public ShippingVO findShipping(String cep) {

        ShippingVO shippingVO = new ShippingVO();

        Frete frete = new Frete();
        frete.codServico("41106");
        frete.codFormato(1);
        frete.altura(11d);
        frete.largura(12d);
        frete.comprimento(16d);
        frete.peso("0,450");
        frete.cepOrigem("01021100");
        // Rua Vinte e Cinco de Março - de 552 ao fim - lado par	Centro	São Paulo/SP	01021-100
        frete.cepDestino(cep);
        try {
            Integer intCep = Integer.parseInt(cep);
        } catch (Exception e) {
            throw new NumeroInvalidoException("Numero Inválido");
        }
        FreteResultItem servico = null;
        try {
            FreteResult result = frete.result();
            servico = result.getServico(41106);
            shippingVO.setDeliveryEstimated(servico.getPrazo());
            shippingVO.setShippingCost(servico.getValor());

            logger.log(Level.INFO, "Ocorreu erro: " + servico.getErro());
            logger.log(Level.INFO, "Mensagem de erro: " + servico.getMensagemDeErro());
            logger.log(Level.INFO, "Prazo: " + servico.getPrazo());
            logger.log(Level.INFO, "Valor: " + servico.getValor());
            logger.log(Level.INFO, "Entrega Domiciliar: " + servico.getEntregaDomiciliar());
            logger.log(Level.INFO, "Entrega Sabado: " + servico.getEntregaSabado());
        } catch (Exception e) {
            // Em caso de falha não tratada os valores estão sendo mocados
            shippingVO.setDeliveryEstimated(12);
            shippingVO.setShippingCost(43.50);
        }
        if (servico == null) {
            throw new ErroDesconhecidoException("Erro no serviço externo");
        } else if (servico.getErro()) {
            throw new CepInvalidoException(servico.getMensagemDeErro());
        }
        return shippingVO;
    }
}