package com.microservicos.pessoa_fisica.repository;

import com.microservicos.pessoa_fisica.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
