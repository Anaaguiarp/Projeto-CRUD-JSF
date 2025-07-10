package com.microservicos.pessoa_fisica.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @Data
public class PessoaFisicaVO {
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String genero;
    private String estadoCivil;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
    private String cep;
    private String cidade;
    private String uf;
    private String logadouro;
    private String numero;
    private String bairro;
    private String complemento;
}
