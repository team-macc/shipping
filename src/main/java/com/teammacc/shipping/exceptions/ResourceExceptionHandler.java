package com.teammacc.shipping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ResourceExceptionHandler {

    private final Logger logger = Logger.getLogger(ResourceExceptionHandler.class.getName());

    private static final String MESSAGE = "MESSAGE: {0}";
    private static final String CAUSE = "CAUSE: {0}";
    private static final String STACK = "STACK: {0}";

    @ExceptionHandler({CepInvalidoException.class, NumeroInvalidoException.class, ErroDesconhecidoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleCepInvalido(Exception e) {
        logger.log(Level.SEVERE, MESSAGE, e.getMessage());
        logger.log(Level.SEVERE, CAUSE, e.getCause() == null ? "" : e.getCause());
        logger.log(Level.SEVERE, STACK, e.getStackTrace());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
