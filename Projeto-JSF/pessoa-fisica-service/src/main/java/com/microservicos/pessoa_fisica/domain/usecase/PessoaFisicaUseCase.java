package com.microservicos.pessoa_fisica.domain.usecase;

import com.microservicos.pessoa_fisica.domain.entity.PessoaFisica;

import java.util.List;

public interface PessoaFisicaUseCase {
    PessoaFisica create(PessoaFisica pessoaFisica);
    PessoaFisica getById(Long id);
    List<PessoaFisica> getAll();
    PessoaFisica update(Long id, PessoaFisica pessoaFisica);
    void delete(Long id);
}
