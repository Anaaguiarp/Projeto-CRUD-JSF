package com.microservicos.pessoa_fisica.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class PessoaFisica {
    private Long id;
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
    private String estado;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;

    public PessoaFisica(Long id, String nome, String cpf, Date dataNasc, String genero, String estadoCivil, String email, String telefone, LocalDate dataCadastro, String cep, String cidade, String estado, String logradouro, String numero, String bairro, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
    }
}
