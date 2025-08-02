package com.microservicos.pessoa_fisica.adapter.output.repository;

import com.microservicos.pessoa_fisica.adapter.output.entity.PessoaFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaJpaRepository extends JpaRepository<PessoaFisicaEntity, Long> {
}
