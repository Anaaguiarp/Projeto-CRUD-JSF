package com.microservicos.pessoa_fisica.port.output;


import com.microservicos.pessoa_fisica.domain.entity.PessoaFisica;

import java.util.List;
import java.util.Optional;

public interface PessoaFisicaRepositoryPort {

    PessoaFisica save(PessoaFisica pf);
    Optional<PessoaFisica> findById(Long id);
    List<PessoaFisica> findAll();
    void deleteById(Long id);

}
