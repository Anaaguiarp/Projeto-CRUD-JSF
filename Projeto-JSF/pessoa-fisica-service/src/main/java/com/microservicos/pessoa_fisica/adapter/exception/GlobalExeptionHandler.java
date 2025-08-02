package com.microservicos.pessoa_fisica.adapter.exception;

import com.microservicos.pessoa_fisica.domain.execption.PessoaFisicaNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(PessoaFisicaNotFoundException.class)
    public ResponseEntity<String> onNotFound(PessoaFisicaNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
