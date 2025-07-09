package com.projetofinal.demo.repository;

import com.projetofinal.demo.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepo extends JpaRepository<PessoaFisica, Integer> {
}
