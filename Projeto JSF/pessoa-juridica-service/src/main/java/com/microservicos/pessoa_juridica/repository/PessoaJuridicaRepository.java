package com.microservicos.pessoa_juridica.repository;

import com.microservicos.pessoa_juridica.entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {}