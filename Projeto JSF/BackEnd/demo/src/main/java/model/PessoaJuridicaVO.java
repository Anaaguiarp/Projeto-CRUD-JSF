package model;

import entity.Endereco;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaJuridicaVO {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
    private Endereco endereco;

    public PessoaJuridicaVO() {
    }

    public PessoaJuridicaVO(String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        PessoaJuridicaVO pessoaJuridicaVO = (PessoaJuridicaVO) obj;
        return Objects.equals(nomeFantasia, pessoaJuridicaVO.nomeFantasia)
                && Objects.equals(razaoSocial, pessoaJuridicaVO.razaoSocial)
                && Objects.equals(cnpj, pessoaJuridicaVO.cnpj)
                && Objects.equals(email, pessoaJuridicaVO.email)
                && Objects.equals(telefone, pessoaJuridicaVO.telefone)
                && Objects.equals(dataCadastro, pessoaJuridicaVO.dataCadastro)
                && Objects.equals(endereco, pessoaJuridicaVO.endereco);
    }
}
