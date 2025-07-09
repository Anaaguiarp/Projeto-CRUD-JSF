package com.projetofinal.demo.repository;

import com.projetofinal.demo.entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepo extends JpaRepository<PessoaJuridica, Integer> {
}
