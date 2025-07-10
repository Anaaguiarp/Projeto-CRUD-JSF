package com.microservicos.pessoa_fisica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 14, unique = true, updatable = false)
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
    private String uf;
    @Column(nullable = false)
    private String logadouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String bairro;
    private String complemento;

    public PessoaFisica() {
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }
}
