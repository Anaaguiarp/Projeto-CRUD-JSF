package com.projetofinal.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private String bairro;
    private String complemento;
    @Column(updatable = false)
    private LocalDate dataCadastro;
    @OneToOne(mappedBy = "endereco")
    private PessoaFisica pessoaFisica;
    @OneToOne(mappedBy = "endereco")
    private PessoaJuridica pessoaJuridica;

    public Endereco() {
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
