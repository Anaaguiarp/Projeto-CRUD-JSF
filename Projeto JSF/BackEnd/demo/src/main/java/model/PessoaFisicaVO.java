package model;

import entity.Endereco;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class PessoaFisicaVO {
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String genero;
    private String estadoCivil;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
    private Endereco endereco;

    public PessoaFisicaVO() {
    }

    public PessoaFisicaVO(String nome, String cpf, Date dataNasc, String genero, String estadoCivil, String email, String telefone, LocalDate dataCadastro, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        PessoaFisicaVO pessoaFisicaVO = (PessoaFisicaVO) obj;
        return Objects.equals(nome, pessoaFisicaVO.nome)
                && Objects.equals(cpf, pessoaFisicaVO.cpf)
                && Objects.equals(dataNasc, pessoaFisicaVO.dataNasc)
                && Objects.equals(genero, pessoaFisicaVO.genero)
                && Objects.equals(estadoCivil, pessoaFisicaVO.estadoCivil)
                && Objects.equals(email, pessoaFisicaVO.email)
                && Objects.equals(telefone, pessoaFisicaVO.telefone)
                && Objects.equals(dataCadastro, pessoaFisicaVO.dataCadastro)
                && Objects.equals(endereco, pessoaFisicaVO.endereco);
    }
}
