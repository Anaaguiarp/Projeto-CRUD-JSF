package com.microservicos.pessoa_fisica.domain.execption;

public class PessoaFisicaNotFoundException extends RuntimeException{
    public PessoaFisicaNotFoundException(String msg) {
        super(msg);
    }
}
