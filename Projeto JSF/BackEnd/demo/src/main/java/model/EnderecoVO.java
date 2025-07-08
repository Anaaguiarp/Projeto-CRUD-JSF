package model;

import java.time.LocalDate;
import java.util.Objects;

public class EnderecoVO {
    private String cep;
    private String cidade;
    private String uf;
    private String logradouro;
    private int numero;
    private String bairro;
    private String complemento;
    private LocalDate dataCadastro;

    public EnderecoVO() {
    }

    public EnderecoVO(String cep, String cidade, String uf, String logradouro, int numero, String bairro, String complemento) {
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        EnderecoVO that = (EnderecoVO) obj;
        return Objects.equals(cep, that.cep)
                && Objects.equals(cidade, that.cidade)
                && Objects.equals(uf, that.uf)
                && Objects.equals(logradouro, that.logradouro)
                && Objects.equals(bairro, that.bairro)
                && Objects.equals(complemento, that.complemento)
                && Objects.equals(dataCadastro, that.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, cidade, uf, logradouro, numero, bairro, complemento, dataCadastro);
    }
}
