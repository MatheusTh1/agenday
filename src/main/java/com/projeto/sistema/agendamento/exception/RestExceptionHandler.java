package com.projeto.sistema.agendamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    private static final String MSG_NAO_ENCONTRADO = "Não encontrado";

    @ExceptionHandler(ResourceNoContentException.class)
    public ResponseEntity<?> handleResourceNoContentException(ResourceNoContentException rfnException) {
        ResourceNotFoundDetails rnfDetails =  ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NO_CONTENT.value())
                .title(MSG_NAO_ENCONTRADO)
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
}
