package com.teammacc.shipping.exceptions;

public class ErroDesconhecidoException extends RuntimeException {
    public ErroDesconhecidoException(String mensagem) {
        super(mensagem);
    }
}
