package com.projetofinal.demo.repository;

import com.projetofinal.demo.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
