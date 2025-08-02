package com.microservicos.pessoa_fisica.adapter.output.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "pessoaFisica")
@Getter @Setter
public class PessoaFisicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 14, unique = true)
    private String cpf;
    @Column(nullable = false, length = 10)
    private Date dataNasc;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private String estadoCivil;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 15)
    private String telefone;
    @Column(updatable = false)
    private LocalDate dataCadastro;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String bairro;
    private String complemento;
}
