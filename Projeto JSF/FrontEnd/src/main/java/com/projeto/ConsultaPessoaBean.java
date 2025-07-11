package com.projeto;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConsultaPessoaBean implements Serializable {
    private List<PessoaDTO> pessoas;
    private PessoaService pessoaService = new PessoaService();

    @PostConstruct
    public void init() {
        pessoas = pessoaService.listarTodasPessoas();
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }
}
