package com.projetofinal.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Endereco endereco;

    public PessoaFisica() {
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
